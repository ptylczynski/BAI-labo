package cloud.ptl.itemmanager.person;

import cloud.ptl.itemmanager.item.ItemDAO;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table("people")
@Data
public class PersonDAO {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;

    @OneToMany(
            mappedBy = "owner"
    )
    private Collection<ItemDAO> items;
}
