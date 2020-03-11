package com.tenpo.sum.web;

import com.tenpo.sum.model.AjaxResponseBody;
import com.tenpo.sum.model.Operation;
import com.tenpo.sum.model.User;
import com.tenpo.sum.repository.OperationRepository;
import com.tenpo.sum.repository.UserRepository;
import com.tenpo.sum.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OperationController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/api/persist", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<?> calculateAndPersist(@Valid @RequestBody Operation operation, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        String username = null;

        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails instanceof UserDetails) {
            username = ((UserDetails) userDetails).getUsername();
        }

        Long userID = userRepository.findByUsername(username).getId();
        operation.setUser_id(userID);
        operation.setAnswer(operation.getValue1() + operation.getValue2());
        operationRepository.save(operation);
        List<Operation> operationArrayList = operationRepository.getAllHistory(userID);
        result.setMsg("success");
        StringBuffer res = new StringBuffer();
        for(Operation operationElement: operationArrayList)
        {
            res.append(operationElement.getValue1() + " + " + operationElement.getValue2() + " = " + operationElement.getAnswer());
            res.append("<br>");
        }

        result.setResult(res.toString());

        return ResponseEntity.ok(result);

    }
}
