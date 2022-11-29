package jcw.javaTeamProjectServer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAvgRatingDto {
    private Long itemKey;
    private double avgRating;
}
