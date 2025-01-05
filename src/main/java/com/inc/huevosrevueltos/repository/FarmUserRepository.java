package com.inc.huevosrevueltos.repository;

import com.inc.huevosrevueltos.model.login.FarmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmUserRepository extends JpaRepository<FarmUser, Long> {
    Optional<FarmUser> findByEmail(String email);
}