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
        employeeList.add(new Employee(1, "John", "male"));
        employeeList.add(new Employee(2, "Mary", "female"));
        employeeList.add(new Employee(3, "Adam", "male"));
        employeeList.add(new Employee(4, "Eve", "female"));
        employeeList.add(new Employee(5, "Dan", "male"));
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

    @RequestMapping(value = "/employees/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable int id)
    {
        for (Employee e:employeeList)
        {
            if (e.getId() == id)
                return e;
        }

        //Throw an error if no employee is found.
        throw new EmployeeNotFoundException();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @ResponseBody
    //It seems that as long as you have a default constructor and appropriate setters for each property, you can
    //automatically convert JSON string to objects.
    public Employee addEmployee(@RequestBody Employee newEmployee)
    {
        employeeList.add(newEmployee);
        return newEmployee;
    }

}
