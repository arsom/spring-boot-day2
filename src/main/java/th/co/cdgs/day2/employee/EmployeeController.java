package th.co.cdgs.day2.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/employee/{id}")
    public EmployeeReponse getById(@PathVariable("id") int id){
        return new EmployeeReponse(id,"Arsom");
    }

    @GetMapping("/employee")
    public List<EmployeeReponse> getAll(){
        return List.of(new EmployeeReponse(1,"Arsom"),new EmployeeReponse(2,"Lek"));
    }
}
