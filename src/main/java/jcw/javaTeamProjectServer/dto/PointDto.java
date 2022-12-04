package jcw.javaTeamProjectServer.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class PointDto {
    private Long memberKey;
    private int point;

    @Builder
    public PointDto(Long memberKey, int point) {
        this.memberKey = memberKey;
        this.point = point;
    }

    public void reducePoint() {
        if (this.point > 0) {
            this.point = -this.point;
        }
    }
}
