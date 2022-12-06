package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.dto.ItemListDTO;
import jcw.javaTeamProjectServer.dto.UpdateAvgRatingDTO;
import jcw.javaTeamProjectServer.entity.Item;
import jcw.javaTeamProjectServer.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item register(final Item item) {
        return itemRepository.save(item);
    }

    public List<ItemListDTO> itemList() {
        List<Item> list = itemRepository.findAll();
        List<ItemListDTO> dtoList = new ArrayList<>();
        for (Item item : list) {
            dtoList.add(convertDto(item));
        }
        return dtoList;
    }

    public List<ItemListDTO> findByName(final String name) {
        List<Item> list = itemRepository.findByItemNameContainingIgnoreCase(name);
        List<ItemListDTO> dtoList = new ArrayList<>();

        for (Item item : list) {
            dtoList.add(convertDto(item));
        }
        return dtoList;
    }

    public List<ItemListDTO> findByCategory(final String category) {
        List<Item> list = itemRepository.findByItemCategory(category);
        List<ItemListDTO> dtoList = new ArrayList<>();

        for (Item item : list) {
            dtoList.add(convertDto(item));
        }
        return dtoList;
    }

    public Optional<Item> findById(final Long id) {
        return itemRepository.findById(id);
    }

    public void updateAvgRating(final UpdateAvgRatingDTO avgRatingDto) {
        Optional<Item> optionalItem = itemRepository.findById(avgRatingDto.getItemKey());
        Item item = optionalItem.get();
        item.setAvgRating(avgRatingDto.getAvgRating());
        itemRepository.save(item);
    }

    /**
     * Item -> ItemListDto
     */
    ItemListDTO convertDto(final Item item) {
        return ItemListDTO.builder()
                .itemKey(item.getItemKey())
                .itemName(item.getItemName())
                .itemAddress(item.getItemAddress())
                .itemPrice(item.getItemPrice())
                .itemCategory(item.getItemCategory())
                .avgRating(item.getAvgRating())
                .itemImage(item.getItemImage())
                .build();
    }
}
