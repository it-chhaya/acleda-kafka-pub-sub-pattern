package kh.edu.cstad.kafkaconsumer.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByTypeAndCreatedAtBetween(ReportType type, LocalDateTime start, LocalDateTime end);

    @Query(value = "SELECT r FROM Report r WHERE r.createdAt >= :startDate " +
            "AND r.createdAt <= :endDate ORDER BY r.createdAt")
    List<Report> findReportsInRange(LocalDateTime startDate, LocalDateTime endDate);

}
