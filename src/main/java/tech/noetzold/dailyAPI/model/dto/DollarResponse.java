package tech.noetzold.dailyAPI.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tech.noetzold.dailyAPI.model.DollarValue;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DollarResponse implements Serializable {

    private Long id;
    @JsonProperty("USDBRL")
    private DollarValue USDBRL;
}

