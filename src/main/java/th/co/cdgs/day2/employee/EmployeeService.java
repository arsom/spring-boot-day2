package th.co.cdgs.day2.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeReponse getEmployeeById(int id) {
       Optional<Employee> result =  employeeRepository.findById(id);
       if(!result.isPresent()){
           throw  new RuntimeException("employee not found with id = "+ id);
       }
        return new EmployeeReponse(id,result.get().getName());
    }
}
