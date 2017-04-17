package com.mitrais.springtraining;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeApplicationTests {

    private MockMvc mockMvc;

    @Before
    public void setup()
    {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new EmployeeController())
                .build();
    }

    @Test
    public void getEmployees() throws Exception
    {
        //You must use double quotes to convert to JSON.
        String result = "[{\"name\":\"John\", \"gender\":\"male\"}, " +
                "{\"name\":\"Adam\", \"gender\":\"male\"}," +
                "{\"name\":\"Dan\", \"gender\":\"male\"}]";

        this.mockMvc.perform(get("/employees?gender=male"))
                .andExpect(content().json(result))
                .andExpect(status().isOk());
    }

    @Test
    public void addEmployee() throws Exception
    {
        this.mockMvc.perform(post("/employees").contentType("application/json")
                .content("{\"name\":\"Wawan\", \"gender\":\"male\"}"))
                .andExpect(content().json("{\"name\":\"Wawan\", \"gender\":\"male\"}"))
                .andExpect(status().isOk());
    }

}
