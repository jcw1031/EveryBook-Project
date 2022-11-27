package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.dto.ItemListDto;
import jcw.javaTeamProjectServer.entity.Item;
import jcw.javaTeamProjectServer.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    /**
     * 상품 등록
     */
    @PostMapping("/register")
    public void register(@RequestBody Item item) {
        Item register = itemService.register(item);
        log.info("item = {}", register);
    }

    /**
     * 상품 카테고리별 리스트
     */
    @GetMapping("/category/{category}")
    public List<ItemListDto> findByCategory(@PathVariable("category") String category) {
        log.info("category");
        return itemService.findByCategory(category);
    }

    /**
     * id로 검색
     */
    @GetMapping("/id/{id}")
    public Item findById(@PathVariable("id") Long id) {
        Optional<Item> item = itemService.findById(id);
        return item.orElse(null);
    }

    /**
     * 상품 리스트
     */
    @GetMapping("/list")
    public List<ItemListDto> itemList() {
        return itemService.itemList();
    }

    /**
     * 이름을 통한 상품 검색
     */
    @GetMapping("/name/{name}")
    public List<Item> findByName(@PathVariable("name") String name) {
        log.info("name = {}", name);
        return itemService.findByName(name);
    }

}
