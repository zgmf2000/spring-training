package com.mitrais.springtraining;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by trainee on 18/04/2017.
 */
@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Employee Not Found!"
)
public class EmployeeNotFoundException extends RuntimeException {}