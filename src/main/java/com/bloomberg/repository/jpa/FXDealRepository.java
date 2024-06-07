package com.bloomberg.repository.jpa;

import com.bloomberg.entity.FXDeal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FXDealRepository extends JpaRepository<FXDeal, String> {
    Optional<FXDeal> findByDealUniqueId(String dealUniqueId);
}