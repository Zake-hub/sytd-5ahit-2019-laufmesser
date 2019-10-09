package at.htl.restaurant.branch;

import at.htl.restaurant.model.branch.Branch;
import at.htl.restaurant.model.branch.LocalBranch;
import at.htl.restaurant.model.branch.Table;

import java.util.Date;

public class EntityFactory {

    public static Branch createBranchData(){
        Branch branch = new Branch();

        branch.setName("Pizza AlCapone");
        branch.setDistrict("Tulln");
        branch.setLocation("A-3470 Kirchberg am Wagram, Marktplatz 3");

        return branch;
    }
    public static LocalBranch createLocalBranchData(){
        LocalBranch localBranch = new LocalBranch();

        localBranch.setName("Pizza AlGartan");
        localBranch.setDistrict("Tulln");
        localBranch.setLocation("A-3470 Kirchberg am Wagram, Marktplatz 3");
        localBranch.setOpenHours(new Date());
        localBranch.setClosingHours(new Date());

        return localBranch;
    }

    public static Table createTableData() {
        Table table = new Table();

        table.setSmokingAllowed(true);
        table.setTableNr(112);

        return table;

    }

    public static Branch updateBranch(Branch branch) {
        branch.setName("Changed");
        return branch;
    }

    public static LocalBranch updateLocalBranch(LocalBranch localBranch){
        localBranch.setName("Changed");
        return localBranch;
    }

    public static Table updateTable(Table table){
        table.setSmokingAllowed(false);
        return table;
    }
}
