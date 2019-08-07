package globant.talentpod.restSample.domain.payroll;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
@Entity
public
class Employee extends ArrayList<Employee> {

    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String role;

    public Employee() {
    }

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}