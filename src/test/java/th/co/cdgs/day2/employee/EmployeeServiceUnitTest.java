package th.co.cdgs.day2.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void get(){
        Employee employee = new Employee();
        employee.setId(50);
        employee.setName("Mock with Unit Test");
        Mockito.when(employeeRepository.findById(50)).thenReturn(Optional.of(employee));
        EmployeeService service = new EmployeeService(employeeRepository);
//        Act
        EmployeeReponse result = service.getEmployeeById(50);
//        Assert
        assertEquals(50,result.getId());
        assertEquals("Mock with Unit Test",result.getName());

    }
}