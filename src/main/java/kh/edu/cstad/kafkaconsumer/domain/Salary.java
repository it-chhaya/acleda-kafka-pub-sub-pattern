package kh.edu.cstad.kafkaconsumer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "salary", schema = "employees")
@IdClass(SalaryId.class)
@Getter
@Setter
@NoArgsConstructor
public class Salary {

    @Id
    private Long employeeId;

    @Id
    private LocalDate fromDate;

    private LocalDate toDate;

    private BigDecimal amount;

}
