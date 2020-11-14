package xin.qust.platform.domain;

import javax.persistence.*;

@Entity
@Table(name = "event_tft_table")
public class EventTftTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    private String _data;


    private String _events;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String get_data() {
        return _data;
    }

    public void set_data(String _data) {
        this._data = _data;
    }

    public String get_events() {
        return _events;
    }

    public void set_events(String _events) {
        this._events = _events;
    }
}
