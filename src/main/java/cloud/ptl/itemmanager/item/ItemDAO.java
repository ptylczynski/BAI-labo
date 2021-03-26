package cloud.ptl.itemmanager.item;

import cloud.ptl.itemmanager.person.PersonDAO;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@Data
public class ItemDAO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Long quantity;

    @ElementCollection(
            targetClass = String.class
    )
    private Collection<String> tags;

    @ManyToOne
    private PersonDAO owner;
}
