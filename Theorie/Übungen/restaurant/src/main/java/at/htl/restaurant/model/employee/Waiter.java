package at.htl.restaurant.model.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "KELLNER")
public class Waiter extends AEmployee{

    @ManyToMany
    @JoinTable(name = "KELLNER_TISCHE")
    private List<at.htl.restaurant.model.branch.Table> tableList = new ArrayList<>();

}
