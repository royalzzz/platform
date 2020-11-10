package xin.qust.platform.domain;

import javax.persistence.*;

@Entity
@Table(name = "event_edge")
public class EventEdge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long from;
    private Long to;
}
