package kh.edu.cstad.kafkaconsumer.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProcessRepository extends JpaRepository<Process, UUID> {

    @Query(value = "SELECT * FROM employees.process_long_running_task(:processId)", nativeQuery = true)
    String executeLongRunningProcedure(@Param("processId") UUID processId);

}
