package me.seula.greeny.domain.info;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoDTO {
    /*
        사용자명
    */
    private String username;
    /*
        프로필 사진 경로
    */
    private String imagePath;
    /*
       사용자 티어
   */
    private String tier;
    /*
        가진 포인트
    */
    private int hasPoint;
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
