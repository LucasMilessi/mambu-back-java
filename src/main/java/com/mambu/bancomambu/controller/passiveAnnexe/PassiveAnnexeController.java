package com.mambu.bancomambu.controller.passiveAnnexe;

import com.mambu.bancomambu.model.account.BlockConsultantDTO;
import com.mambu.bancomambu.model.account.ResponseSeizeAccountDTO;
import com.mambu.bancomambu.model.passiveAnnexe.ApplyInterestRequestDTO;
import com.mambu.bancomambu.model.passiveAnnexe.BlockAndSeizeRequestDTO;
import com.mambu.bancomambu.model.passiveAnnexe.BlockSearchRequestDTO;
import com.mambu.bancomambu.model.passiveAnnexe.onBoarding.OnBoardingRequestDTO;
import com.mambu.bancomambu.model.passiveAnnexe.onBoarding.OnBoardingResponseDTO;
import com.mambu.bancomambu.model.transaction.TransactionDTO;
import com.mambu.bancomambu.service.passive.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class PassiveAnnexeController {

    @Autowired
    private SerchAndApplyInterestService applyInterestService;

    @Autowired
    private OnBoardingService onBoardingService;

    @Autowired
    private BlockSeizureAccountService blockSeizureAccountService;

    @Autowired
    private BlockAndConsultAccountService blockAndConsultAccountService;

    @Autowired
    private GetLastMovementService getLastMovementService;

    @PostMapping(value = "/onBoarding", consumes = "*/*", produces = "application/json")
    public Mono<OnBoardingResponseDTO> onBoarding(@RequestBody OnBoardingRequestDTO onBoardingRequestDTO){

        return onBoardingService.onBoarding(onBoardingRequestDTO);
    }

    @GetMapping("/last/movemnt/{id}")
    public Flux<TransactionDTO> getLastMovement(@PathVariable String id, @RequestParam String limit,
                                                @RequestParam String detailsLevel) throws Exception {

        return getLastMovementService.getLastTransactions(id, limit, detailsLevel);
    }

    @PostMapping("/block/seize/{id}")
    public Mono<ResponseSeizeAccountDTO> blockAndSeizeAccount(@PathVariable String id, @RequestBody BlockAndSeizeRequestDTO blockAndSeizeRequestDTO){

        return blockSeizureAccountService.blockAndSeizeAccount(id, blockAndSeizeRequestDTO);
    }

    @PostMapping("/applyInterest")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Flux<Object> serchAndApplyInterest(@RequestParam String offset, @RequestParam String limit,
                                              @RequestParam String paginationDetails,
                                              @RequestParam String detailsLevel,
                                              @RequestBody ApplyInterestRequestDTO interestRequestDTO){

        return applyInterestService.serchAndApplyInterest(offset, limit, paginationDetails,
                detailsLevel, interestRequestDTO);
    }

    @PostMapping("/blockAccount/{id}")
    private Mono<BlockConsultantDTO> blockAndSearch(@PathVariable String id, @RequestBody BlockSearchRequestDTO blockSearchRequestDTO){

        return blockAndConsultAccountService.blockAndConsultAccount(id, blockSearchRequestDTO);
    }

}
