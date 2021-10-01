package th.co.cdgs.day2.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getById() throws  Exception{
        Mockito.when(employeeService.getEmployeeById(1)).thenReturn(new EmployeeReponse(1,"Lek"));
        MvcResult mvcResult = mvc.perform(get("/employee/1")).andExpect(status().isOk()).andReturn();
        ObjectMapper mapper = new ObjectMapper();
        EmployeeReponse employeeReponse = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(),EmployeeReponse.class);
        assertEquals(1,employeeReponse.getId());
        assertEquals("Lek",employeeReponse.getName());

    }
}
