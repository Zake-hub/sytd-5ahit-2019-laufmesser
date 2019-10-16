package at.htl.restaurant.model.branch;

import at.htl.restaurant.model.AEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@javax.persistence.Table(name = "SESSEL")
public class Chair extends AEntity {

    @NotNull
    @NotBlank
    @Column
    private String code;
    
    @ManyToOne
    @JoinColumn(name="TABLE_ID")
    private at.htl.restaurant.model.branch.Table table;
}
