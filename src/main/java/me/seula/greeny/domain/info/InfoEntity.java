package me.seula.greeny.domain.info;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        프로필 수정 url
    */
    private String profileEditUrl;
    /*
        혜택 보기 url
    */
    private String benefitsUrl;
    /*
        포인트 얻는 법 URL
    */
    private String earningPointsUrl;
}
