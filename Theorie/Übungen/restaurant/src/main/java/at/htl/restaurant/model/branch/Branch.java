package at.htl.restaurant.model.branch;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "FILIALEN")
public class Branch extends ABranch {

}
