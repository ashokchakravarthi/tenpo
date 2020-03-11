package com.tenpo.sum.repository;

import com.tenpo.sum.model.Operation;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long>
{
    @Query("SELECT o FROM Operation o WHERE o.user_id = :userID")
    List<Operation> getAllHistory(@Param("userID")Long userID);
}
