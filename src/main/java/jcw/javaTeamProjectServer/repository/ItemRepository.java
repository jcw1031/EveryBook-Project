package jcw.javaTeamProjectServer.repository;

import jcw.javaTeamProjectServer.dto.ItemListDto;
import jcw.javaTeamProjectServer.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNameContainingIgnoreCase(String itemName);

    @Query(value = "SELECT new jcw.javaTeamProjectServer.dto.ItemListDto(i.itemKey, i.itemName, i.itemCategory, i.itemAddress, i.itemPrice, COALESCE(AVG(r.reviewStar), 0)) " +
            "FROM Item i LEFT OUTER JOIN Review r " +
            "ON i.itemKey = r.itemKey " +
            "GROUP BY i.itemKey")
    List<ItemListDto> findAllDto();

    @Query(value = "SELECT new jcw.javaTeamProjectServer.dto.ItemListDto(i.itemKey, i.itemName, i.itemCategory, i.itemAddress, i.itemPrice, COALESCE(AVG(r.reviewStar), 0)) " +
            "FROM Item i LEFT OUTER JOIN Review r " +
            "ON i.itemKey = r.itemKey WHERE i.itemCategory = :category " +
            "GROUP BY i.itemKey")
    List<ItemListDto> findByItemCategory(@Param("category") String category);

}
