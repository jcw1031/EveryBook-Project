package jcw.javaTeamProjectServer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookKey;

    private Long memberKey;
    private Long itemKey;
    private String bookDate; //예약 시점 일자
    private String itemDate; //상품 예약일
}
