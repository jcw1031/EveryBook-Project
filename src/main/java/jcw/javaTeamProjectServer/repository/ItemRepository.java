package jcw.javaTeamProjectServer.repository;

import jcw.javaTeamProjectServer.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNameContainingIgnoreCase(String name);

    List<Item> findByItemCategory(String category);

    /*@Query(value = "SELECT new jcw.javaTeamProjectServer.dto.ItemListDto(i.itemKey, i.itemName, i.itemCategory" +
            ", i.itemAddress, i.itemPrice, COALESCE(AVG(r.reviewStar), 0)) " +
            "FROM Item i LEFT OUTER JOIN Review r " +
            "ON i.itemKey = r.itemKey " +
            "GROUP BY i.itemKey")
    List<ItemListDto> findAllDto();*/

    /*@Query(value = "SELECT new jcw.javaTeamProjectServer.dto.ItemListDto(i.itemKey, i.itemName, i.itemCategory" +
            ", i.itemAddress, i.itemPrice, COALESCE(AVG(r.reviewStar), 0)) " +
            "FROM Item i LEFT OUTER JOIN Review r " +
            "ON i.itemKey = r.itemKey WHERE i.itemCategory = :category " +
            "GROUP BY i.itemKey")
    List<ItemListDto> findByItemCategory(@Param("category") String category);*/

    /*@Query(value = "SELECT new jcw.javaTeamProjectServer.dto.ItemListDto(i.itemKey, i.itemName, i.itemCategory" +
            ", i.itemAddress, i.itemPrice, COALESCE(AVG(r.reviewStar), 0)) " +
            "FROM Item i LEFT OUTER JOIN Review r " +
            "ON i.itemKey = r.itemKey WHERE i.itemName = :name " +
            "GROUP BY i.itemKey")
    List<ItemListDto> findByItemName(@Param("name") String name);*/

}
