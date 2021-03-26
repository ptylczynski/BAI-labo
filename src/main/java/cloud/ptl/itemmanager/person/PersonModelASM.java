package cloud.ptl.itemmanager.person;

import cloud.ptl.itemmanager.item.ItemModelASM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonModelASM {
    @Autowired
    private ItemModelASM itemModelASM;

    public PersonModel assemble(PersonDAO entity){
        return PersonModel.builder()
                .id(entity.getId())
                .items(
                        entity.getItems().stream().map(
                                el -> this.itemModelASM.assemble(el)
                        ).collect(Collectors.toList())
                )
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();
    }
}
