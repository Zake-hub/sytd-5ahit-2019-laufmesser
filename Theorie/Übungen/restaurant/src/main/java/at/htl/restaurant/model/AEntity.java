package at.htl.restaurant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public class AEntity implements Serializable{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

}
