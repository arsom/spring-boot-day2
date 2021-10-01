package th.co.cdgs.day2.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    @AfterEach
    public void clearData(){
        employeeRepository.deleteAll();
    }

    @Test
    public void getById(){
        Employee demo  = new Employee();
        demo.setName("Arsom");
        employeeRepository.save(demo);
        EmployeeReponse result = restTemplate.getForObject("/employee/1",EmployeeReponse.class);
        assertEquals(1,result.getId());
        assertEquals("Arsom",result.getName());


    }

    @Test
    public void getEmployee(){
        List<EmployeeReponse> results = restTemplate.getForObject("/employee", List.class);
        assertEquals(2,results.size());
    }
}