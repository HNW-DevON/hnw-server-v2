package me.seula.hnw.global;

import me.seula.hnw.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration

/*
    @EnableWebSecurity

    아래 구현체를 바탕으로
    Spring Security를 설정함
*/
@EnableWebSecurity
public class SecurityConfig {

    /*
        AuthenticationManager를 만들 AuthenticationConfiguration 받기
    */
    private final AuthenticationConfiguration authenticationConfiguration;

    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration) {
        this.authenticationConfiguration = authenticationConfiguration;
    }

    /*
        AuthenticationManager 빈 생성
    */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    /*
        해시암호를 위한 메서드
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
                .requestMatchers("/login", "/register", "/asdf").permitAll()
                .anyRequest().authenticated()
        );

        http.addFilterAt(new JwtAuthenticationFilter(authenticationManager(authenticationConfiguration)), UsernamePasswordAuthenticationFilter.class);

        // 세션 설정
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
