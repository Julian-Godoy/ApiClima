package com.example.ApiClima.repositories;

import com.example.ApiClima.models.QueryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<QueryLog, Long> {



}
