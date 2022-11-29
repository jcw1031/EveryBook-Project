package jcw.javaTeamProjectServer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemKey;

    private String itemName;
    private String itemBody;
    private int itemPrice;
    private String itemAddress;
    private String itemCategory;
    private String itemPhone;
    private double avgRating;

}
