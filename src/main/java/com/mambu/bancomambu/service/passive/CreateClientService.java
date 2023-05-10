package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.client.ClientDTO;
import reactor.core.publisher.Mono;

public interface CreateClientService {
    Mono<ClientDTO> createClient(ClientDTO clientDTO);
}
