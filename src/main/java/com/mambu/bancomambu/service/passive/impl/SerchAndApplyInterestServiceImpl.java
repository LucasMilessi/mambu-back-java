package com.mambu.bancomambu.service.passive.impl;

import com.mambu.bancomambu.model.interest.InterestDTO;
import com.mambu.bancomambu.model.passiveAnnexe.ApplyInterestRequestDTO;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import com.mambu.bancomambu.service.passive.ApplyInterestService;
import com.mambu.bancomambu.service.passive.SearchTransactionInterestService;
import com.mambu.bancomambu.service.passive.SerchAndApplyInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

@Service
public class SerchAndApplyInterestServiceImpl implements SerchAndApplyInterestService {

    @Autowired
    private SearchTransactionInterestService interestService;

    @Autowired
    private ApplyInterestService applyInterestService;



    @Override
    public Flux<Object> serchAndApplyInterest(String offset, String limit, String paginationDetails,
                                              String detailsLevel, ApplyInterestRequestDTO interestRequestDTO){

            var  filter = RequestTransactionDTO.builder()
                    .filterCriteria(Arrays.asList(interestRequestDTO.getFilterCriteria()))
                    .build();

            return interestService.serchTransactionInterest(offset, limit, paginationDetails, detailsLevel,
                    filter).flatMap( searchResp -> {

                var interest = InterestDTO.builder()
                        .interestApplicationDate(currentDate())
                        .notes(interestRequestDTO.getNotes())
                        .build();
                    return applyInterestService.applyInterest(searchResp.getId(), interest);
            });
    }

    private String currentDate(){

        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.of("-05:00")).minusSeconds(1);
        String dateNow = now.toString();

        return dateNow;
    }

}
