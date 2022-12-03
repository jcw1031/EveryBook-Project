package jcw.javaTeamProjectServer.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    private String itemImage;
}
