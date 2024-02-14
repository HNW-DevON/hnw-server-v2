package me.seula.greeny.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import me.seula.greeny.domain.point.entity.PointEntity;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        사용자명
    */
    @Column(unique = true, nullable = false)
    private String username;

    /*
        비밀번호
    */
    @Column(nullable = false)
    private String password;

    /*
        이름
    */
    @Setter
    @Column(nullable = false)
    private String name;

    /*
        생년월일
    */
    @Column(nullable = false)
    private String birth;

    /*
        프로필 사진 경로
    */
    @Setter
    private String imagePath;

    /*
        총 경험치
    */
    @Setter
    @Column(nullable = false)
    private int totalExp;

    /*
        사용자 티어
    */
    @Setter
    @Column(nullable = false)
    private String tier;

    /*
        가진 포인트
    */
    @Setter
    @Column(nullable = false)
    private int hasPoint;

    /*
        포인트 기록
    */
    @OneToMany(mappedBy = "user")
    private List<PointEntity> pointHistory;

    /*
        권한 정보 (임시)
    */
    @Column(nullable = false)
    private String role;

    @Builder
    public UserEntity(
            String username,
            String password,
            String name,
            String birth,
            int totalExp,
            String tier,
            int hasPoint,
            String role)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.totalExp = totalExp;
        this.tier = tier;
        this.hasPoint = hasPoint;
        this.role = role;
    }
}
