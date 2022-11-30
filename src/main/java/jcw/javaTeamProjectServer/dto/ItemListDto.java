package jcw.javaTeamProjectServer.dto;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemListDto {
    private Long itemKey;
    private String itemName;
    private String itemCategory;
    private String itemAddress;
    private int itemPrice;
    private Double avgRating;
    private String itemImage;
}