package com.github.edsandrof.infnetjavaweb.infrastructure.repository;

import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleBuyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleBuyerRepository extends JpaRepository<VehicleBuyer, Long> {
}
