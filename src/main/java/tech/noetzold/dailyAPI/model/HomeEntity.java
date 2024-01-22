package tech.noetzold.dailyAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeEntity {

    private Long id;
    private String entity_id;
    private String state;

    private Map<String, Object> attributes;
    private Date last_changed;
    private Date last_updated;

    @OneToOne(cascade = CascadeType.ALL)
    private Context context;
}
