package at.htl.restaurant.service.branch;

import at.htl.restaurant.domain.branch.IABranchRepository;
import at.htl.restaurant.model.branch.Branch;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/branches")
@RestController
public class BranchService {

    @Autowired
    private IABranchRepository repository;

    private Logger log;

    @GetMapping(path = "requestbranch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Branch> requestBranch()
    {
        log.info("All Branches!");
        return repository.findBranchesByName("Bergwirt Schrammel");

    }
}
