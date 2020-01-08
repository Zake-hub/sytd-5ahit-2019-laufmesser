package at.htl.sytd.project_approvement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ManagementProject extends AProject {

    private ELawType lawType;

}
