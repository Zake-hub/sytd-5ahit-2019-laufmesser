package at.htl.restaurant.model.branch;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "FILIALEN_GASTGARTEN")
public class LocalBranch extends ABranch {

    @Temporal(TemporalType.TIME)
    @Column(name = "OEFFNUNGS_ZEIT", nullable = false)
    private Date openHours;

    @Temporal(TemporalType.TIME)
    @Column(name = "SCHLUSS_ZEIT", nullable = false)
    private Date closingHours;

}
