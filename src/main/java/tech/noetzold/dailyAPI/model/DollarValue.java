package tech.noetzold.dailyAPI.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DollarValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String codein;
    private String name;
    private BigDecimal high;
    private BigDecimal low;
    @JsonProperty("varBid")
    private BigDecimal variationBid;
    @JsonProperty("pctChange")
    private BigDecimal percentChange;
    private BigDecimal bid;
    private BigDecimal ask;
    private BigDecimal timestamp;
    @JsonProperty("create_date")
    private String createDate;
    @Column(name = "request_date")
    private Date requestDate;
}
