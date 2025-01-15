package kh.edu.cstad.kafkaconsumer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "employee", schema = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String gender;
    private Date brithDate;
    private Date hireDate;

}
