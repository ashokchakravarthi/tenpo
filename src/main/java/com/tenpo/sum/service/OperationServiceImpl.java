package com.tenpo.sum.service;

import com.tenpo.sum.model.Operation;
import com.tenpo.sum.model.User;
import com.tenpo.sum.repository.OperationRepository;
import com.tenpo.sum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService
{
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public void save(Operation operation)
    {
        operationRepository.save(operation);
    }

    @Override
    public Optional<Operation> getAllHistory(Long userID)
    {
        return operationRepository.findById(userID);
    }
}
