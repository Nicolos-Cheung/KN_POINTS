package zn.leave.infrastructure.common.event;

import zn.leave.domain.leave.event.LeaveEvent;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    public void publish(LeaveEvent event){
        //send to MQ
        //mq.send(event);
    }
}