package com.postech.adapter.driven.infra;

import com.postech.core.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringClientRepository extends JpaRepository<Client, Long> {
}
