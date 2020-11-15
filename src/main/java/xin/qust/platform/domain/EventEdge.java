package xin.qust.platform.domain;

import javax.persistence.*;

@Entity
@Table(name = "event_edge")
public class EventEdge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromNode;
    private Long toNode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromNode() {
        return fromNode;
    }

    public void setFromNode(Long fromNode) {
        this.fromNode = fromNode;
    }

    public Long getToNode() {
        return toNode;
    }

    public void setToNode(Long toNode) {
        this.toNode = toNode;
    }
}
