package com.acorp.ventimetriquadri.external_integration.email_service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailSenderResponse {

    private String status;
    private String message;
}
