package jcw.javaTeamProjectServer.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewListDTO {
    private Long reviewKey;
    private String reviewBody;
    private int reviewStar;
    private String reviewDate;
    private String memberName;
    private Long memberKey;
}
