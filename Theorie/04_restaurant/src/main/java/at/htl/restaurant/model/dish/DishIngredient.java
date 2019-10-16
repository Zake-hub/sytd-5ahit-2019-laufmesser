package at.htl.restaurant.model.dish;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "GERICHTE_ZUTATEN")
public class DishIngredient implements Serializable{

    @NotNull
    @EmbeddedId
    private DishIngredientID dishIngredientID;

    @Setter
    @NotNull
    @Min(0)
    @Max(100)
    @Column(name = "MENGE", nullable = false)
    private Integer amount;

    public DishIngredient(final Dish dish, final Ingredient ingredient){
        dishIngredientID = new DishIngredientID(dish, ingredient);
    }

    @Column
    private Long version;

}
