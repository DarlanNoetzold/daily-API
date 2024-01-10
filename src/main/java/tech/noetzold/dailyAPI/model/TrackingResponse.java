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
public class TrackingResponse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "host")
    private String host;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "trackingResponse")
    private List<Event> eventos;

    @Column(name = "time")
    private double time;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "servico")
    private String servico;

    @Column(name = "ultimo")
    private String ultimo;

}