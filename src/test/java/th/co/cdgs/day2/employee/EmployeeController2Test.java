package th.co.cdgs.day2.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeController2Test {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void getById2(){
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("Sai");
        Mockito.when(employeeRepository.findById(100)).thenReturn(Optional.of(employee));

        EmployeeReponse result = restTemplate.getForObject("/employee/100",EmployeeReponse.class);
        assertEquals(100,result.getId());
        assertEquals("Sai",result.getName());


    }

}