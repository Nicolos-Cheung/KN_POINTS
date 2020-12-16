package zn.leave.application.service;

import zn.leave.domain.person.entity.Person;
import zn.leave.domain.person.service.PersonDomainService;
import zn.leave.infrastructure.client.AuthFeignClient;
import zn.leave.infrastructure.common.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginApplicationService{

    @Autowired
    AuthFeignClient authService;
    @Autowired
    PersonDomainService personDomainService;

    public Response login(Person person){
        //调用鉴权微服务
        return authService.login(person);
    }
}