package com.zn.interfaces.facade;

import com.zn.infrastructure.common.api.Response;
import com.zn.interfaces.dto.PersonDTO;
import com.zn.application.service.LoginApplicationService;
import com.zn.interfaces.assembler.PersonAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthApi {

    @Autowired
    LoginApplicationService loginApplicationService;

    @PostMapping("/login")
    public Response login(PersonDTO personDTO) {
        try {
            return loginApplicationService.login(PersonAssembler.toDO(personDTO));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
