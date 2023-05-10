package com.mambu.bancomambu.controller;

import com.mambu.bancomambu.model.product.ProductDTO;
import com.mambu.bancomambu.service.passive.GetProductByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private GetProductByIdService getProduct;

    @GetMapping("/product/{id}")
    public Mono<ProductDTO> getAll(@PathVariable String id, @RequestParam String offset, @RequestParam String limit,
                                   @RequestParam String paginationDetails, @RequestParam String detailsLevel){

        return getProduct.getProductByID(id, offset, limit, paginationDetails, detailsLevel);
    }
}
