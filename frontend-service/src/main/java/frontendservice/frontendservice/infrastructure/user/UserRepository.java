package com.app.frontendservice.infrastructure.user;

import com.app.frontendservice.domain.model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUserName(String userName);

}
