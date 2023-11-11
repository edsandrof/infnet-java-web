package com.github.edsandrof.infnetjavaweb.infrastructure.repository;

import com.github.edsandrof.infnetjavaweb.model.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Optional<Employee> findByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Optional<Employee> findByCustomEmailQuery(String email);
}
