package com.housing_cost_simulator.infrastructure.repository.mysql;

import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.persistence.UserPersistence;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}
