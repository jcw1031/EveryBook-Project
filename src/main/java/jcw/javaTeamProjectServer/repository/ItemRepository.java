package jcw.javaTeamProjectServer.repository;

import jcw.javaTeamProjectServer.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    public List<Item> findByItemNameContainingIgnoreCase(String itemName);
}
