package at.htl.restaurant.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Table
@Entity
public class Chair extends AEntity {

    @Column(length = 8, nullable = false)
    @Size(max = 8)
    @NotNull
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private at.htl.restaurant.model.Table table;
}
