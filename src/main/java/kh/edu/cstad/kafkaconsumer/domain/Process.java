package kh.edu.cstad.kafkaconsumer.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "processes", schema = "employees")
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String processName;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

}
