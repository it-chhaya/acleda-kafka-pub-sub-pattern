package kh.edu.cstad.kafkaconsumer.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface EmployeeReportResponse {
    Long getEmployeeUniqueId();

    String getEmployeeFirstName();

    String getEmployeeLastName();

    LocalDate getEmployeeDob();

    String getDepartmentName();

    String getTitleName();

    BigDecimal getCurrentSalary();

    LocalDateTime getUpdatedAt();
}
