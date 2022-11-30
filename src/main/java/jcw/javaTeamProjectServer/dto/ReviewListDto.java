package jcw.javaTeamProjectServer.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewListDto {
    private Long reviewKey;
    private String reviewBody;
    private int reviewStar;
    private String reviewDate;
    private String memberName;
}
