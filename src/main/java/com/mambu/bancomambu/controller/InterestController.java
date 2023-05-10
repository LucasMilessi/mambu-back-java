package com.mambu.bancomambu.controller;

import com.mambu.bancomambu.model.interest.InterestDTO;
import com.mambu.bancomambu.service.passive.ApplyInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class InterestController {

    @Autowired
    private ApplyInterestService applyInterestService;

    @PostMapping("interest/{id}/apply")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Object> searchTransactionInterest(@PathVariable String id, @RequestBody InterestDTO interestDTO) {

        return applyInterestService.applyInterest(id, interestDTO);
    }
}
