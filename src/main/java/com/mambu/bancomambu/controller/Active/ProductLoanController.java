package com.mambu.bancomambu.controller.Active;

import com.mambu.bancomambu.model.product.ProductLoanDTO;
import com.mambu.bancomambu.service.active.ProductLoanByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ProductLoanController {

    @Autowired
    private ProductLoanByIdService productLoanByIdService;

    @GetMapping("/productLoan/{id}")
    public Mono<ProductLoanDTO> getAll(@PathVariable String id, @RequestParam String offset, @RequestParam String limit,
                                       @RequestParam String paginationDetails, @RequestParam String detailsLevel){

        return productLoanByIdService.getAccountById(id, offset, limit, paginationDetails, detailsLevel);
    }
}
