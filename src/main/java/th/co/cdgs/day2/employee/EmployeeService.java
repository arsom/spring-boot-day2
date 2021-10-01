package th.co.cdgs.day2.employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public EmployeeReponse getEmployeeById(int id) {
        return new EmployeeReponse(id,"Arsom");
    }
}
