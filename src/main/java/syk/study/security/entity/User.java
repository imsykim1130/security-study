package syk.study.security.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Jpa 의 프록시 생성을 위해 기본생성자가 필요하다. 외부에 공개하면 위험하기 때문에 access level 을 protected 로 설정한다
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String password;
    private String role;

    public static User createUser(String name, String password, String role) {
        User user = new User();
        user.name = name;
        user.password = password;
        user.role = role;
        return user;
    }
}
