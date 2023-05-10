package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.client.ClientDTO;
import reactor.core.publisher.Flux;

public interface AllClientService {
    Flux<ClientDTO> getAll();
}
