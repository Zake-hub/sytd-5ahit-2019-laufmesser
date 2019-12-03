package at.htl.mom.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@AllArgsConstructor
public class Employee implements Serializable {
    private String firstName;
    private String lastName;
}
