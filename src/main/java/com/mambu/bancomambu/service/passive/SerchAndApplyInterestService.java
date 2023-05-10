package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.passiveAnnexe.ApplyInterestRequestDTO;
import reactor.core.publisher.Flux;

public interface SerchAndApplyInterestService {
    Flux<Object> serchAndApplyInterest(String offset, String limit, String paginationDetails,
                                       String detailsLevel, ApplyInterestRequestDTO interestRequestDTO);
}
