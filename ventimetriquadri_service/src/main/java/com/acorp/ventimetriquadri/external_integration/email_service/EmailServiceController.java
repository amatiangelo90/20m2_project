package com.acorp.ventimetriquadri.external_integration.email_service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(path = "api/v1/app/emailsender")
@CrossOrigin(origins = "*")
public class EmailServiceController {

    @Autowired
    private EmailEngineService emailEngineService;

    public EmailSenderResponse sendEmail(EmailEntity emailEntity) throws Exception {
        return emailEngineService.sendEmail(emailEntity);
    }
}
