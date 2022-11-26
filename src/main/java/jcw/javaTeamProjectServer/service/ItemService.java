package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.entity.Item;
import jcw.javaTeamProjectServer.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item register(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> itemList() {
        return itemRepository.findAll();
    }

    public List<Item> findByName(String name) {
        return itemRepository.findByItemNameContainingIgnoreCase(name);
    }

    public List<Item> findByCategory(String category) {
        return itemRepository.findByItemCategory(category);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }
}
