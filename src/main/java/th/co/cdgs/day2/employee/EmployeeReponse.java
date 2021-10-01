package th.co.cdgs.day2.employee;

import lombok.Data;

@Data
public class EmployeeReponse {
    private int id;
    private String name;

    public EmployeeReponse(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
