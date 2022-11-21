package jcw.javaTeamProjectServer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String id;
    private String password;
    private String memberName;
    private String memberPhone;
    private int age;
}
