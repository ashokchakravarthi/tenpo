package com.tenpo.sum.service;

import com.tenpo.sum.model.Operation;

import java.util.List;
import java.util.Optional;

public interface OperationService
{
    void save(Operation operation);

    List<Operation> getAllHistory(Long userID);
}
