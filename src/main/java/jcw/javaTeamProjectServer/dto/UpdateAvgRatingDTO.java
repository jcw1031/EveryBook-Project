package jcw.javaTeamProjectServer.dto;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAvgRatingDTO {
    private Long itemKey;
    private Double avgRating;
}
