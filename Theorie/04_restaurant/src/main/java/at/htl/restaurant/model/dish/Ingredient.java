package at.htl.restaurant.model.dish;

import at.htl.restaurant.model.AEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "ZUTATEN")
public class Ingredient extends AEntity{

    @NotBlank
    @Size(max = 50)
    @Column(name = "BEZEICHNUNG", length = 50, nullable = false, unique = true)
    private String name;

    @NotNull
    @Min(0)
    @Max(10000)
    @Column(name = "LAGERBESTAND", nullable = false)
    private Integer storedUnits;

}
