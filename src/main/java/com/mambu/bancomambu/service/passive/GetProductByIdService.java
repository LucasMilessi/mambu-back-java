package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.client.ClientDTO;
import com.mambu.bancomambu.model.product.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetProductByIdService {

    Mono<ProductDTO> getProductByID(String id, String offset, String limit, String paginationDetails, String detailsLevel);
}
