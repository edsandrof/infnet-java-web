package com.github.edsandrof.infnetjavaweb.infrastructure.repository;

import com.github.edsandrof.infnetjavaweb.model.domain.VehicleSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleSaleRepository extends JpaRepository<VehicleSale, Long> {
}
