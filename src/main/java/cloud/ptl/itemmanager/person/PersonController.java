package cloud.ptl.itemmanager.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonModelASM personModelASM;

    @GetMapping("/{id}")
    public PersonModel findOne(
            @PathVariable("id") Long id
    ) throws Exception {
        return this.personModelASM.assemble(
                this.personService.findOne(id)
        );
    }

    @PostMapping("")
    public PersonModel postOne(
            PersonDAO personDAO,
            BindingResult bindingResult
    ) throws Exception {
        if(!bindingResult.hasErrors())
            return this.personModelASM.assemble(
                    this.personService.createIfNotExist(personDAO)
            );
        else
            throw new Exception("Error in Person Object");
    }

    @DeleteMapping("/{id}")
    public void deleteOne(
            @PathVariable("id") Long id
    ){
        this.personService.deleteOne(id);
    }
}
