package th.co.cdgs.day2.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void getById(){
        EmployeeReponse result = restTemplate.getForObject("/employee/1",EmployeeReponse.class);
        assertEquals(1,result.getId());
        assertEquals("Arsom",result.getName());
    }
}