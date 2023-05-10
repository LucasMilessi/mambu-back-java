package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.passiveAnnexe.onBoarding.OnBoardingRequestDTO;
import com.mambu.bancomambu.model.passiveAnnexe.onBoarding.OnBoardingResponseDTO;
import reactor.core.publisher.Mono;

public interface OnBoardingService {
    Mono<OnBoardingResponseDTO> onBoarding(OnBoardingRequestDTO onBoardingRequestDTO);
}
