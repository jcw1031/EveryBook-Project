package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.dto.ItemListDto;
import jcw.javaTeamProjectServer.dto.UpdateAvgRatingDto;
import jcw.javaTeamProjectServer.entity.Item;
import jcw.javaTeamProjectServer.repository.ItemRepository;
import jcw.javaTeamProjectServer.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Item> list = itemRepository.findAll();
        List<ItemListDto> dtoList = new ArrayList<>();
        for (Item item : list) {
            dtoList.add(convertDto(item));
        }
        return dtoList;
    }

    public List<ItemListDto> findByName(String name) {
        List<Item> list = itemRepository.findByItemNameContainingIgnoreCase(name);
        List<ItemListDto> dtoList = new ArrayList<>();

        for (Item item : list) {
            dtoList.add(convertDto(item));
        }
        return dtoList;
    }

    public List<ItemListDto> findByCategory(String category) {
        List<Item> list = itemRepository.findByItemCategory(category);
        List<ItemListDto> dtoList = new ArrayList<>();

        for (Item item : list) {
            dtoList.add(convertDto(item));
        }
        return dtoList;
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public void updateAvgRating(UpdateAvgRatingDto avgRatingDto) {
        Optional<Item> optionalItem = itemRepository.findById(avgRatingDto.getItemKey());
        Item item = optionalItem.get();
        item.setAvgRating(avgRatingDto.getAvgRating());
        System.out.println(avgRatingDto.getAvgRating()+";너ㅏㅣㅇ러ㅏㅣㅁㄴ디ㅏㅁ퍼ㅗㄴ어ㅏㅗ롬ㄴㄷㅍㄱ러몮엃ㄴㅁㅎ덯ㄹ머ㅗㄴㅇ롲ㅎㅁ도ㅓㅁㄴㅇㅎ");
        itemRepository.save(item);
    }

    /**
     * Item -> ItemListDto
     */
    ItemListDto convertDto(Item item) {
        return ItemListDto.builder()
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
