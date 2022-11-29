package jcw.javaTeamProjectServer.service;

import jcw.javaTeamProjectServer.dto.ItemListDto;
import jcw.javaTeamProjectServer.dto.UpdateAvgRatingDto;
import jcw.javaTeamProjectServer.entity.Item;
import jcw.javaTeamProjectServer.repository.ItemRepository;
import jcw.javaTeamProjectServer.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ReviewService reviewService;

    public Item register(Item item) {
        return itemRepository.save(item);
    }

    public List<ItemListDto> itemList() {
        return itemRepository.findAllDto();
    }

    public List<ItemListDto> findByName(String name) {
        return itemRepository.findByItemName(name);
    }

    public List<ItemListDto> findByCategory(String category) {
        return itemRepository.findByItemCategory(category);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public void updateAvgRating(UpdateAvgRatingDto avgRatingDto) {
        Optional<Item> optionalItem = itemRepository.findById(avgRatingDto.getItemKey());
        Item item = optionalItem.get();
        item.setAvgRating(avgRatingDto.getAvgRating());
        itemRepository.save(item);
    }
}
