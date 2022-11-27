package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.dto.ItemListDto;
import jcw.javaTeamProjectServer.entity.Item;
import jcw.javaTeamProjectServer.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
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

    public List<ItemListDto> itemList() {
        return itemRepository.findAllDto();
    }

    public List<Item> findByName(String name) {
        return itemRepository.findByItemNameContainingIgnoreCase(name);
    }

    public List<ItemListDto> findByCategory(String category) {
        return itemRepository.findByItemCategory(category);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

}
