package com.acorp.ventimetriquadri.website.controller;
import com.acorp.ventimetriquadri.website.entity.MessageWhatsAppCampainEntity;
import com.acorp.ventimetriquadri.website.service.WhatsAppMessageSenderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(path = "api/v1/website/whatsapp/")
@CrossOrigin(origins = "*")
public class WhatsAppCampainController {

    @Autowired
    private WhatsAppMessageSenderService whatsAppMessageSenderService;

    @PostMapping(path = "/startcampain")
    public void save(MessageWhatsAppCampainEntity whatAppMessageEntityList) { whatsAppMessageSenderService.sendBroadcastMessage(whatAppMessageEntityList); }

}
