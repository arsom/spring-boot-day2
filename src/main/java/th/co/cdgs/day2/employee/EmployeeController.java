package th.co.cdgs.day2.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee/{id}")
    public EmployeeReponse getById(@PathVariable("id") int id){
        return new EmployeeReponse(id,"Arsom");
    }
}
