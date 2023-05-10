package com.mambu.bancomambu.util.impl;

import com.mambu.bancomambu.model.transaction.FilterCriteriaDTO;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import com.mambu.bancomambu.model.transaction.SortingCriteriaDTO;
import com.mambu.bancomambu.util.CreateFilterUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateFilterUtilImpl implements CreateFilterUtil {


    @Override
    public RequestTransactionDTO createFilterPago(String encodedKey){

        var filterCriteria = FilterCriteriaDTO.builder()
                .field("type")
                .operator("EQUALS")
                .value("REPAYMENT")
                .build();

        var filterCriteria2 = FilterCriteriaDTO.builder()
                .field("parentAccountKey")
                .operator("EQUALS")
                .value(encodedKey)
                .build();

        var filterCriteria3 = FilterCriteriaDTO.builder()
                .field("adjustmentTransactionKey")
                .operator("EMPTY")
                .build();

        var sortingCriteria = SortingCriteriaDTO.builder().field("valueDate")
                .order("ASC")
                .build();

        List<FilterCriteriaDTO> filterCriteriaFin = new ArrayList<>();
        filterCriteriaFin.add(0,filterCriteria);
        filterCriteriaFin.add(1,filterCriteria2);
        filterCriteriaFin.add(2,filterCriteria3);

        RequestTransactionDTO requestTransactionDTO = new RequestTransactionDTO();
        requestTransactionDTO.setFilterCriteria(filterCriteriaFin);
        requestTransactionDTO.setSortingCriteria(sortingCriteria);

        return requestTransactionDTO;

    }

    @Override
    public RequestTransactionDTO createFilterDisbursement(String encodedKey){

        var filterCriteria = FilterCriteriaDTO.builder()
                .field("type")
                .operator("EQUALS")
                .value("DISBURSEMENT")
                .build();

        var filterCriteria2 = FilterCriteriaDTO.builder()
                .field("parentAccountKey")
                .operator("EQUALS")
                .value(encodedKey)
                .build();

        var filterCriteria3 = FilterCriteriaDTO.builder()
                .field("adjustmentTransactionKey")
                .operator("EMPTY")
                .build();

        var sortingCriteria = SortingCriteriaDTO.builder().field("valueDate")
                .order("ASC")
                .build();

        List<FilterCriteriaDTO> filterCriteriaFin = new ArrayList<>();
        filterCriteriaFin.add(0,filterCriteria);
        filterCriteriaFin.add(1,filterCriteria2);
        filterCriteriaFin.add(2,filterCriteria3);

        RequestTransactionDTO requestTransactionDTO = new RequestTransactionDTO();
        requestTransactionDTO.setFilterCriteria(filterCriteriaFin);
        requestTransactionDTO.setSortingCriteria(sortingCriteria);

        return requestTransactionDTO;

    }
}
