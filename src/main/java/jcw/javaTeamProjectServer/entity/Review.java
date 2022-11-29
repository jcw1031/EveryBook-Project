package jcw.javaTeamProjectServer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
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
