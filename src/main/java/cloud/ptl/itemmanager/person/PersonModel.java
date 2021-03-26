package cloud.ptl.itemmanager.person;

import cloud.ptl.itemmanager.item.ItemModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonModel {
    private Long id;
    private String name;
    private String surname;
    private Collection<ItemModel> items;
}
