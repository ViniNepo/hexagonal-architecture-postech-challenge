package com.postech.adapter.driven.infra;

import com.postech.core.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringOrderRepository extends JpaRepository<Order, Long> {
}
