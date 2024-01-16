package tech.noetzold.dailyAPI.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HomeEntity {
    private String entity_id;
    private String state;
    private Map<String, Object> attributes;
    private Date last_changed;
    private Date last_updated;

    @OneToOne(cascade = CascadeType.ALL)
    private Context context;
}
