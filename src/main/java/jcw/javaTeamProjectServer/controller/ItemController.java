package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.entity.Item;
import jcw.javaTeamProjectServer.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/list")
    public List<Item> itemList() {
        return itemService.itemList();
    }

    @GetMapping("/name/{name}")
    public List<Item> findByName(@PathVariable("name") String name) {
        log.info("name = {}", name);
        return itemService.findByName(name);
    }
}
