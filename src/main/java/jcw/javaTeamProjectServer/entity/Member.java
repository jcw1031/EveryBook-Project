package jcw.javaTeamProjectServer.entity;

import lombok.Builder;
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
    private Long memberKey;

    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberPhone;
    private int memberAge;

    public Member(Long memberKey, String memberId, String memberPassword, String memberName, String memberPhone, int memberAge) {
        this.memberKey = memberKey;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberAge = memberAge;
    }

    public Member() {

    }
}