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
    @Column(name = "member_key")
    private Long id;

    private String memberId;
    @Column(name = "member_password")
    private String password;
    @Column(name = "member_name")
    private String name;
    @Column(name = "member_phone")
    private String phone;
    @Column(name = "member_age")
    private int age;
}
