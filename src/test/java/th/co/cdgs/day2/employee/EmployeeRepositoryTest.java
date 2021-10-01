package th.co.cdgs.day2.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void case01(){
        Employee demo  = new Employee();
        demo.setName("Arsom");
        employeeRepository.save(demo);

        Optional<Employee> result = employeeRepository.findById(1);
        assertTrue(result.isPresent());
        assertEquals(1,result.get().getId());
        assertEquals("Arsom",result.get().getName());
    }

    @Test
    public void case02(){
        Optional<Employee> result = employeeRepository.findById(1);
        assertFalse(result.isPresent());
    }

}