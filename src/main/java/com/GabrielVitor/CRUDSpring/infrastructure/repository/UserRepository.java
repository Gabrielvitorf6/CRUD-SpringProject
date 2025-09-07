package com.GabrielVitor.CRUDSpring.infrastructure.repository;
import com.GabrielVitor.CRUDSpring.infrastructure.entitys.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    void deleteByEmail(String email);


    Optional<User> findByEmail(String email);

    List<User> email(String email);
}
