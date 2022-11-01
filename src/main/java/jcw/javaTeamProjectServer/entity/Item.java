package jcw.javaTeamProjectServer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String itemName;
    private String itemDescription;
    private int itemPrice;
    private String itemAddress;
    private String itemCategory;
    private String itemPhone;
    private String itemImage;
    private int itemLimitCount;
}
