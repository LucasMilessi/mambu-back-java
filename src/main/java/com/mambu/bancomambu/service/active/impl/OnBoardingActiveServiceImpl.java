package com.mambu.bancomambu.service.active.impl;

import com.mambu.bancomambu.model.activeAnnexe.onBoarding.OnBoardingDTO;
import com.mambu.bancomambu.model.activeAnnexe.onBoarding.OnBoardingActiveResponseDTO;
import com.mambu.bancomambu.model.client.ClientDTO;
import com.mambu.bancomambu.model.loan.LoanDTO;
import com.mambu.bancomambu.model.product.ProductLoanDTO;
import com.mambu.bancomambu.service.active.CreateAccountLoanService;
import com.mambu.bancomambu.service.active.OnBoardingActiveService;
import com.mambu.bancomambu.service.active.ProductLoanByIdService;
import com.mambu.bancomambu.service.passive.CreateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OnBoardingActiveServiceImpl implements OnBoardingActiveService {

    @Autowired
    private CreateClientService createClientService;

    @Autowired
    private ProductLoanByIdService productLoanByIdService;

    @Autowired
    private CreateAccountLoanService createAccount;

    private final String OFFSET = "0";
    private final String LIMIT = "10";
    private final String PAGINATIONDETAILS = "OFF";
    private final String DETAILSLEVEL = "FULL";

    @Override
    public Mono<OnBoardingActiveResponseDTO> onBoarding(OnBoardingDTO onBoardingDTO){

        ClientDTO clientDTO = createClient(onBoardingDTO);

        return createClientService.createClient(clientDTO).flatMap( cliRes ->
                productLoanByIdService.getAccountById(onBoardingDTO.getProductId(),
                        OFFSET, LIMIT, PAGINATIONDETAILS, DETAILSLEVEL).flatMap( prodResp -> {
                    var account = createAccountLoan(cliRes, prodResp, onBoardingDTO);

                    return createAccount.createLoanAccount(account).map( accResponse ->
                            OnBoardingActiveResponseDTO.builder()
                                    .client(cliRes)
                                    .loan(accResponse)
                                    .build()
                    );
                })
        );
    }

    private ClientDTO createClient(OnBoardingDTO client) {

        return ClientDTO.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .personalizados(client.getPersonalizados())
                .build();
    }

    private LoanDTO createAccountLoan(ClientDTO clientDTO, ProductLoanDTO productDTO, OnBoardingDTO onBoardingDTO){

        return LoanDTO.builder()
                .accountHolderKey(clientDTO.getEncodedKey())
                .accountHolderType(onBoardingDTO.getAccountHolderType())
                .productTypeKey(productDTO.getEncodedKey())
                .interestSettings(onBoardingDTO.getInterestSettings())
                .loanAmount(onBoardingDTO.getLoanAmount())
                .scheduleSettings(onBoardingDTO.getScheduleSettings())
                .penaltySettings(onBoardingDTO.getPenaltySettings())
                .build();
    }
}
