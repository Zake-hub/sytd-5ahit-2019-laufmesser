package at.htl.sytd.project_approvement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestFundingProject extends AProject{

    private Boolean isEUFunded;

    private Boolean isFFGFunded;

    private Boolean isFWFFunded;

}
