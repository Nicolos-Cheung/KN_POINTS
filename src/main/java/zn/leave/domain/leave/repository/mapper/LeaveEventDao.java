package zn.leave.domain.leave.repository.mapper;

import zn.leave.domain.leave.repository.po.LeaveEventPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveEventDao extends JpaRepository<LeaveEventPO, String> {

}
