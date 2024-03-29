package tech.noetzold.dailyAPI.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class TabnewsResponse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_local;
    private String owner_id;
    private String parent_id;
    private String slug;
    private String title;
    private String status;
    private String source_url;
    private String created_at;
    private String updated_at;
    private String published_at;
    private String deleted_at;
    private Integer tabcoins;
    private String owner_username;
    private Integer children_deep_count;
    @Column(name = "request_date")
    private Date requestDate;
}
