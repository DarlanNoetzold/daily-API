package tech.noetzold.dailyAPI.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sender;
    private String subject;
    @Column(columnDefinition="TEXT")
    private String content;
    private Date sentDate;
    @Column(name = "request_date")
    private Date requestDate;
}
