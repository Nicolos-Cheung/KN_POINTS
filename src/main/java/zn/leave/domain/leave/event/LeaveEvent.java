package zn.leave.domain.leave.event;

import com.alibaba.fastjson.JSON;
import zn.leave.domain.leave.entity.Leave;
import zn.leave.infrastructure.common.event.DomainEvent;
import zn.leave.infrastructure.util.IdGenerator;
import lombok.Data;

import java.util.Date;

@Data
public class LeaveEvent extends DomainEvent {

    LeaveEventType leaveEventType;

    public static LeaveEvent create(LeaveEventType eventType, Leave leave){
        LeaveEvent event = new LeaveEvent();
        event.setId(IdGenerator.nextId());
        event.setLeaveEventType(eventType);
        event.setTimestamp(new Date());
        event.setData(JSON.toJSONString(leave));
        return event;
    }
}
