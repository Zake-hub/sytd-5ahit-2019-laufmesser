package at.htl.sytd.project_approvement.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "json-type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ManagementProject.class, name = "management"),
        @JsonSubTypes.Type(value = RequestFundingProject.class, name = "requestFundingProject")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class AProject implements Serializable {

    private Facility facility;

    private String title;

    private String description;

    private EProjectState projectState;

}
