package at.htl.restaurant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Table(name = "Branches")
@Entity
public abstract class ABranch extends AEntity{

    @Column(length = 30, nullable = false)
    @Size(max = 30)
    @NotNull
    private String district;

    @Column(length = 200, nullable = false)
    @Size(max = 200)
    @NotNull
    private String address;

    @Column(length = 50, nullable = false, unique = true)
    @Size(max = 50)
    @NotNull
    private String name;
}
