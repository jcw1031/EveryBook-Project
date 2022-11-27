package jcw.javaTeamProjectServer.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemListDto {
    private Long itemKey;
    private String itemName;
    private String itemCategory;
    private String itemAddress;
    private int itemPrice;
    private Double avgRating;
}