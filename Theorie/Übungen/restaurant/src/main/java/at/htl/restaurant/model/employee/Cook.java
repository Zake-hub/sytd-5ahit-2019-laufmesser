package at.htl.restaurant.model.employee;

import at.htl.restaurant.model.dish.Dish;
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
@Table(name = "KOECHE")
public class Cook extends AEmployee{

    @ManyToMany
    @JoinTable(name = "KOECHE_GERICHTE")
    private List<Dish> dishList = new ArrayList<>();


}
