package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.activeAnnexe.onBoarding.OnBoardingDTO;
import com.mambu.bancomambu.model.activeAnnexe.onBoarding.OnBoardingActiveResponseDTO;
import reactor.core.publisher.Mono;

public interface OnBoardingActiveService {
    Mono<OnBoardingActiveResponseDTO> onBoarding(OnBoardingDTO onBoardingDTO);
}
