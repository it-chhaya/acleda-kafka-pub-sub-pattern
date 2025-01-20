package kh.edu.cstad.kafkaconsumer.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private ReportType type;
    private LocalDateTime createdAt;
    private String status;
    private String filePath;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}
