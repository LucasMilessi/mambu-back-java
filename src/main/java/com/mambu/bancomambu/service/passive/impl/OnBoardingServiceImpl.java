package com.mambu.bancomambu.service.passive.impl;

import com.mambu.bancomambu.model.account.AccountDTO;
import com.mambu.bancomambu.model.client.ClientDTO;
import com.mambu.bancomambu.model.passiveAnnexe.onBoarding.OnBoardingRequestDTO;
import com.mambu.bancomambu.model.passiveAnnexe.onBoarding.OnBoardingResponseDTO;
import com.mambu.bancomambu.model.product.ProductDTO;
import com.mambu.bancomambu.service.passive.CreateAccountClienteService;
import com.mambu.bancomambu.service.passive.CreateClientService;
import com.mambu.bancomambu.service.passive.GetProductByIdService;
import com.mambu.bancomambu.service.passive.OnBoardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OnBoardingServiceImpl implements OnBoardingService {

    @Autowired
    private CreateClientService createClientService;

    @Autowired
    private GetProductByIdService productByIdService;

    @Autowired
    private CreateAccountClienteService accountClienteService;

    private final String OFFSET = "0";
    private final String LIMIT = "10";
    private final String PAGINATIONDETAILS = "OFF";
    private final String DETAILSLEVEL = "FULL";

    @Override
    public Mono<OnBoardingResponseDTO> onBoarding(OnBoardingRequestDTO onBoardingRequestDTO){

        ClientDTO clientDTO = createClient(onBoardingRequestDTO);

        return createClientService.createClient(clientDTO).flatMap( cliRes ->
                 productByIdService.getProductByID(onBoardingRequestDTO.getDepositProductId(),
                         OFFSET, LIMIT, PAGINATIONDETAILS, DETAILSLEVEL).flatMap( prodResp -> {
                        var account = createAccount(cliRes, prodResp, onBoardingRequestDTO);

                        return accountClienteService.createAccount(account).map( accResponse ->
                                OnBoardingResponseDTO.builder()
                                        .client(cliRes)
                                        .account(accResponse)
                                        .build()
                                );
                })
        );
    }

    private AccountDTO createAccount(ClientDTO clientDTO, ProductDTO productDTO, OnBoardingRequestDTO onBoardingRequestDTO){

        return AccountDTO.builder()
                        .accountHolderKey(clientDTO.getEncodedKey())
                        .accountHolderType(onBoardingRequestDTO.getAccountHolderType())
                        .name(onBoardingRequestDTO.getName())
                        .productTypeKey(productDTO.getEncodedKey())
                        .notes(onBoardingRequestDTO.getNotes())
                        .accountState(onBoardingRequestDTO.getAccountState())
                        .accountType(productDTO.getType())
                        .currencyCode(productDTO.getCurrencySettings().getCurrencies().get(0).getCurrencyCode())
                        .build();
    }

    private ClientDTO createClient(OnBoardingRequestDTO client) {

        return ClientDTO.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .personalizados(client.getPersonalizados())
                .build();
    }
}
