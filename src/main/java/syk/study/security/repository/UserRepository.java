package syk.study.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syk.study.security.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
