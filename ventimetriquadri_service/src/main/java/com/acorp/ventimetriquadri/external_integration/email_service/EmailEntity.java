package com.acorp.ventimetriquadri.external_integration.email_service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class EmailEntity {

    @JsonProperty("branch_name")
    String branchName;
    @JsonProperty("branch_number")
    String branchNumber;
    @JsonProperty("order_code")
    String orderCode;
    @JsonProperty("message")
    String message;
    @JsonProperty("supplier_name")
    String supplierName;
    @JsonProperty("supplier_email")
    String supplierEmail;
    @JsonProperty("user_name")
    String user_name;
    @JsonProperty("user_email")
    String userEmail;
    @JsonProperty("branch_address")
    String branchAddress;
    @JsonProperty("branch_city")
    String branchCity;
    @JsonProperty("branch_cap")
    String branchCap;
    @JsonProperty("delivery_date")
    String deliveryDate;

}
