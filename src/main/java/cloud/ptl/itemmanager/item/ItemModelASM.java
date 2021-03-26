package cloud.ptl.itemmanager.item;

import org.springframework.stereotype.Service;

@Service
public class ItemModelASM {
    public ItemModel assemble(ItemDAO entity){
        return ItemModel.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .name(entity.getName())
                .tags(entity.getTags())
                .quantity(entity.getQuantity())
                .build();
    }
}
