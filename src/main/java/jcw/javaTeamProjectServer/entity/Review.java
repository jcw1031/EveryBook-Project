package jcw.javaTeamProjectServer.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewKey;

    private Long memberKey;
    private Long itemKey;
    private int reviewStar;
    private String reviewBody;
    private String reviewDate;
}
