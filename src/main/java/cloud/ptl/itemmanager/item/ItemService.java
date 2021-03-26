package cloud.ptl.itemmanager.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    private ItemDAO create(ItemDAO item){
        return this.itemRepository.save(item);
    }

    public ItemDAO createIfNotExist(ItemDAO itemDAO){
        if(this.itemRepository.existsById(itemDAO.getId()))
            return itemDAO;
        else
            return this.create(itemDAO);
    }

    public ItemDAO updateOne(ItemDAO item){
        return this.itemRepository.save(item);
    }

    public void deleteOne(ItemDAO item){
        this.itemRepository.delete(item);
    }

    public ItemDAO findOne(Long id) throws Exception {
        Optional<ItemDAO> optionalItemDAO =
                this.itemRepository.findById(id);
        if(optionalItemDAO.isEmpty())
            throw new Exception("Item does not exist");
        else
            return optionalItemDAO.get();
    }
}
