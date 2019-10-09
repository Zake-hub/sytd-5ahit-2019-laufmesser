package at.htl.restaurant.model.branch;

import at.htl.restaurant.model.AEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@javax.persistence.Table(name = "TISCHE")
public class Table extends AEntity{

    @ManyToOne
    @JoinColumn(name="FILIALE_ID")
    private ABranch branch;

    @NotNull
    @Min(0)
    @Column(name = "TISCH_NR", nullable = false)
    private Integer tableNr;

    @NotNull
    @Column(name = "IST_RAUCHER_TISCH", nullable = false)
    private Boolean smokingAllowed;

}
