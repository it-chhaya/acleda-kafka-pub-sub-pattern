package kh.edu.cstad.kafkaconsumer.domain;

import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SalaryId implements Serializable {

    private Long employeeId;

    private LocalDate fromDate;

}
