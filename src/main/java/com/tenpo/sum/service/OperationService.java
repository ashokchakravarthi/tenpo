package com.tenpo.sum.service;

import com.tenpo.sum.model.Operation;

import java.util.Optional;

public interface OperationService
{
    void save(Operation operation);

    Optional<Operation> getAllHistory(Long userID);
}
