package com.mitrais.springtraining;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trainee on 17/04/2017.
 */
@Controller
public class EmployeeController {
    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeController()
    {
        employeeList.add(new Employee("John", "male"));
        employeeList.add(new Employee("Mary", "female"));
        employeeList.add(new Employee("Adam", "male"));
        employeeList.add(new Employee("Eve", "female"));
        employeeList.add(new Employee("Dan", "male"));
    }

    @RequestMapping (value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployeeByGender(@RequestParam(value = "gender", defaultValue = "male") String gender)
    {
        List<Employee> result = new ArrayList<>();
        for (Employee e:employeeList)
        {
            if (e.getGender().toLowerCase().equals(gender))
            {
                result.add(e);
            }
        }
        return result;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee body)
    {
        employeeList.add(body);
        return body;
    }

}
