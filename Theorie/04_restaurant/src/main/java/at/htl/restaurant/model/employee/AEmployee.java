package at.htl.restaurant.model.employee;

import at.htl.restaurant.model.AEntity;
import at.htl.restaurant.model.branch.ABranch;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "ANGESTELLTE")
public abstract class AEmployee extends AEntity{

    @ManyToMany
    @JoinTable(name="FILIALEN_ANGESTELLTE",
            foreignKey = @ForeignKey(name="FILIALEN_ID"),
            inverseForeignKey = @ForeignKey(name="ANGESTELLTEN_ID"))
    private List<ABranch> branchList;

    @NotBlank
    @Size(max = 50)
    @Column(name = "VORNAME", length = 50, nullable = false)
    private String givenName;

    @NotBlank
    @Size(max = 50)
    @Column(name = "NACHNAME", length = 50, nullable = false)
    private String lastName;

    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "SOZIALVERSICHERUNGS_NR", length = 10, nullable = false, unique = true)
    private String socialSecurityCode;

}
