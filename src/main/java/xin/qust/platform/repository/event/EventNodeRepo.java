package xin.qust.platform.repository.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xin.qust.platform.domain.event.EventNode;

import java.util.List;

public interface EventNodeRepo extends JpaRepository<EventNode, Long> {
    @Query(value = "select * from event_node where label like %:str%", nativeQuery = true)
    List<EventNode> findByNodeLike(@Param("str") String str);

    List<EventNode> findByLabel(String str);
}
