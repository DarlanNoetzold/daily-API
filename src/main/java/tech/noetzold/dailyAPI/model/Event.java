package tech.noetzold.dailyAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private String data;

    @Column(name = "hora")
    private String hora;

    @Column(name = "local")
    private String local;

    @Column(name = "status")
    private String status;

    @ElementCollection
    @CollectionTable(name = "event_sub_status", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "sub_status")
    private List<String> subStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tracking_response_id")
    private TrackingResponse trackingResponse;

}