package at.htl.restaurant.service;

import at.htl.restaurant.domain.IABranchRepository;
import at.htl.restaurant.model.branch.ABranch;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RequestMapping(path = "/branches")
@RestController
public class BranchResource {

    private static Logger logger = LoggerFactory.getLogger(BranchResource.class);

    @Autowired
    private IABranchRepository branchRepository;

    @Transactional
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ABranch read(@PathVariable Long id) {
        logger.info("read branch: " + id);
        ABranch branch = branchRepository.getOne(id);
        return (ABranch) Hibernate.unproxy(branch);
    }

    @Transactional
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ABranch create(@RequestBody ABranch branch) {
        branchRepository.save(branch);
        logger.info("created branch with id: " + branch.getId());

        return (ABranch) Hibernate.unproxy(branch);
    }

    @Transactional
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody ABranch branch, @PathVariable Long id) {
        branchRepository.save(branch);
        logger.info("updated branch with id: " + branch.getId());
    }

    @Transactional
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        branchRepository.delete(branchRepository.getOne(id));
        logger.info("branch removed id: " + id);
    }
}
