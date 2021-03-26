package cloud.ptl.itemmanager.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemModel {
    private Long id;
    private String name;
    private String description;
    private Long quantity;
    private Collection<String> tags;
}
