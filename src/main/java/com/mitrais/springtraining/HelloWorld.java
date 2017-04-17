package com.mitrais.springtraining;

import org.springframework.stereotype.Component;

/**
 * Created by trainee on 17/04/2017.
 */
@Component
public class HelloWorld {
    private String message;

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void printMessage()
    {
        System.out.println(message);
    }
}
