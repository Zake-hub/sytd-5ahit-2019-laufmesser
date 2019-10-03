package at.htl.restaurant.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@javax.persistence.Table
@Entity
public class Table extends AEntity {

    @Column(length = 1, nullable = false)
    @Size(max = 1)
    @NotNull
    @Value("false")
    private Boolean is_smoke_table;

    @Column
    private Integer table_nr;
}
