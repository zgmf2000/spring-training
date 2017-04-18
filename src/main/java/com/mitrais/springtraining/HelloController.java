package com.mitrais.springtraining;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by trainee on 17/04/2017.
 */
@Controller
public class HelloController {

    //Each @RequestMapping must have a @ResponseBody directly below the method.
    @RequestMapping (value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam(value = "message", defaultValue = "Hello Spring!") String message)
    {
        return message;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestBody String message)
    {
        return message;
    }

    @RequestMapping(value = "/hello/{message}", method = RequestMethod.PUT)
    @ResponseBody
    public String helloURI(@PathVariable String message)
    {
        return message;
    }

    @RequestMapping(value = "/hello-jsp", method = RequestMethod.GET)
    //If you're using JSP files, no need to use @ResponseBody annotation!
    public String hello(ModelMap modelMap)
    {
        modelMap.addAttribute("message", "Hello Spring from JSP.");
        //The application will search for hello.jsp.
        return "hello";
    }

}
