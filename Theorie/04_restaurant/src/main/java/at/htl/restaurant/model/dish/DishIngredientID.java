package at.htl.restaurant.model.dish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Embeddable
public class DishIngredientID implements Serializable{

    public DishIngredientID(Dish dish, Ingredient ingredient) {
        this.dish = dish;
        this.ingredient = ingredient;
    }

    @ManyToOne
    @JoinColumn(name = "GERICHT_ID", nullable = false, updatable = false)
    private at.htl.restaurant.model.dish.Dish dish;

    @ManyToOne
    @JoinColumn(name = "ZUTAT_ID", nullable = false, updatable = false)
    private at.htl.restaurant.model.dish.Ingredient ingredient;


}
