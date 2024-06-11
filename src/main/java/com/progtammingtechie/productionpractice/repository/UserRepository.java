package com.progtammingtechie.productionpractice.repository;

import com.progtammingtechie.productionpractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
