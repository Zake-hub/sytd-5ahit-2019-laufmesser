package at.htl.restaurant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public class AEntity implements Serializable{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Version
    private Long version;

}