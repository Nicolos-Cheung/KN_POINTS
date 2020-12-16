package com.zn.domain.leave.event;

import com.alibaba.fastjson.JSON;
import com.zn.domain.leave.entity.Leave;
import com.zn.infrastructure.common.event.DomainEvent;
import com.zn.infrastructure.util.IdGenerator;
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
