package kh.edu.cstad.kafkaconsumer.domain;

import kh.edu.cstad.kafkaconsumer.dto.EmployeeReportResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "SELECT * FROM employees.get_employee_report(?1)", nativeQuery = true)
    List<EmployeeReportResponse> getEmployeeReport(String departmentId);

}
