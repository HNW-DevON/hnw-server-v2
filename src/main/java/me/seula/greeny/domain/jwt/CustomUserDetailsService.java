package me.seula.greeny.domain.jwt;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.user.entity.UserEntity;
import me.seula.greeny.domain.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userData = userRepository.findByUsername(username);

        if (userData.isPresent()) {
            return new CustomUserDetails(userData.get());
        }

        throw new UsernameNotFoundException("Username Not Found : " + username);
    }
}
