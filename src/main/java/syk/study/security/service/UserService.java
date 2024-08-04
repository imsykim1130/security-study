package syk.study.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import syk.study.security.entity.User;
import syk.study.security.repository.UserRepository;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public void join(User user) {
        if(userRepository.findByName(user.getName()).isPresent()){
            throw new RuntimeException("이미 존재하는 회원입니다.");
        }
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // spring security 가 db 를 이용하여 유저 인증 진행하게 만들기
        User user = userRepository.findByName(username).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
    }
}
