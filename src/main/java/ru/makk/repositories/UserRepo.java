package ru.makk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makk.domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
