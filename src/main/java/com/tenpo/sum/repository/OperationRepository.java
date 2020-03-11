package com.tenpo.sum.repository;

import com.tenpo.sum.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long>
{
}
