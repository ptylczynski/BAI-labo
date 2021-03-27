package cloud.ptl.itemmanager.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemModelASM itemModelASM;

    @GetMapping("/{id}")
    public ItemModel findOne(
            @PathVariable("id") Long id
    ) throws Exception {
        return this.itemModelASM.assemble(
                this.itemService.findOne(id)
        );
    }

    @PostMapping("")
    public ItemModel postOne(
            ItemDAO itemDAO,
            BindingResult bindingResult
    ) throws Exception {
        if(!bindingResult.hasErrors())
            return this.itemModelASM.assemble(
                    this.itemService.createIfNotExist(itemDAO)
            );
        else
            throw new Exception("Error in Item Object");
    }

    @DeleteMapping("/{id}")
    public void deleteOne(
            @PathVariable("id") Long id
    ){
        this.itemService.deleteOne(id);
    }
}