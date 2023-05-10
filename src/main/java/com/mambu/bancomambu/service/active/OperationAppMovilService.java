package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.activeAnnexe.OperationAppMovilDTO;
import reactor.core.publisher.Mono;

public interface OperationAppMovilService {
    Mono<OperationAppMovilDTO> operationAppMovil(String id);
}
