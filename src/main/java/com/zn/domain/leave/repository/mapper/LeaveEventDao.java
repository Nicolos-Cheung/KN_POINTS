package com.zn.domain.leave.repository.mapper;

import com.zn.domain.leave.repository.po.LeaveEventPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveEventDao extends JpaRepository<LeaveEventPO, String> {

}
