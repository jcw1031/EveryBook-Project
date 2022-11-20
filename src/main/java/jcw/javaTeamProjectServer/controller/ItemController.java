package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.entity.Item;
import jcw.javaTeamProjectServer.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    /**
     * 상품 등록
     */
    @PostMapping("/register")
    public void register(@RequestBody Item item) {
        Item register = itemService.register(item);
        log.info("item = {}", register);
    }

    /**
     *상품 카테고리별 리스트
     */
    @GetMapping("/category/{category}")
    public List<Item> findByCategory(@PathVariable("category") String category) {
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
    public List<Item> itemList() {
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
