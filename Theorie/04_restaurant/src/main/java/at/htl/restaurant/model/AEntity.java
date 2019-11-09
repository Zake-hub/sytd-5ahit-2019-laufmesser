package at.htl.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
@Getter
@Setter
@MappedSuperclass
public abstract class AEntity implements Serializable{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Version
    private Long version;

}
