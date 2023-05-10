package com.mambu.bancomambu.controller;

import com.mambu.bancomambu.model.client.ClientDTO;
import com.mambu.bancomambu.service.passive.AllClientService;
import com.mambu.bancomambu.service.passive.CreateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private AllClientService allClientService;

    @Autowired
    private CreateClientService createClientService;

    @GetMapping("/clients")
    public Flux<ClientDTO> getAll(){

        return allClientService.getAll();
    }

    @PostMapping("/add/client")
    public Mono<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {

        return createClientService.createClient(clientDTO);
    }
}
