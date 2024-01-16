package tech.noetzold.dailyAPI.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Context {
    private String id;
    private String parent_id;
    private String user_id;

}
