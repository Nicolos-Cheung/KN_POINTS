package zn.leave.interfaces.facade;

import zn.leave.application.service.LoginApplicationService;
import zn.leave.infrastructure.common.api.Response;
import zn.leave.interfaces.assembler.PersonAssembler;
import zn.leave.interfaces.dto.PersonDTO;
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
