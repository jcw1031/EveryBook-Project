package jcw.javaTeamProjectServer.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@DynamicUpdate
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberKey;

    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberPhone;
    private int memberAge;
    private int memberPoint;

    @Builder
    public Member(Long memberKey, String memberId, String memberPassword, String memberName, String memberPhone
            , int memberAge, int memberPoint) {
        this.memberKey = memberKey;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberAge = memberAge;
        this.memberPoint = memberPoint;
    }
}