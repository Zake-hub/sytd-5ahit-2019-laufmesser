package at.htl.restaurant.model.branch;


import at.htl.restaurant.model.AEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "A_FILIALEN")
public abstract class ABranch extends AEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "NAME", length = 50, nullable = false, unique = true)
    private String name;

    @NotBlank
    @Size(max = 30)
    @Column(name = "BEZIRK", length = 30, nullable = false)
    private String district;

    @NotBlank
    @Size(max =  200)
    @Column(name = "ADRESSE", length = 200, nullable = false)
    private String location;


}
