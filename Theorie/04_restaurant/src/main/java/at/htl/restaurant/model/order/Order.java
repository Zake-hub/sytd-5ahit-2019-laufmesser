package at.htl.restaurant.model.order;

import at.htl.restaurant.model.AEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "BESTELLUNGEN")
public class Order extends AEntity{

    @NotNull
    @Column(name = "BESTELLUNGS_ID", nullable = false)
    private Integer orderID;

    @NotNull
    @Column(name = "BESTELLUNGS_ZEITPUNKT", nullable = false)
    private Date orderDate;

}
