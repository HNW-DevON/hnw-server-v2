package me.seula.hnw.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

/*
    @EnableWebSecurity

    아래 구현체를 바탕으로
    Spring Security를 설정함
*/
@EnableWebSecurity
public class SecurityConfig {

    /*
        해시암호를 풀기위한 메서드
    */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CSRF 끄기
        http.csrf((auth) -> auth.disable());

        // Form 로그인 방식 끄기
        http.formLogin((auth) -> auth.disable());

        // Http Basic 로그인 방식 끄기
        http.httpBasic((auth) -> auth.disable());

        // 글로벌 인가 작업
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/login", "/register").permitAll()
                .anyRequest().authenticated()
        );

        // 세션 설정
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
