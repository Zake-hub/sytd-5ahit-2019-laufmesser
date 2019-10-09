package at.htl.restaurant.model.dish;

import at.htl.restaurant.model.AEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "GERICHTE")
public class Dish extends AEntity{

    @NotBlank
    @Size(max = 50)
    @Column(name = "BEZEICHNUNG", length = 50, nullable = false, unique = true)
    private String name;

    @NotNull
    @Min(0)
    @Column(name = "PREIS", nullable = false)
    private Integer price;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ART", nullable = false)
    private EDishType dishType;

}
