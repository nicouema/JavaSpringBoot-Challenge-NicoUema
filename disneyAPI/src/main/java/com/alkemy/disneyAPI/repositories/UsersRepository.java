package com.alkemy.disneyAPI.repositories;

import com.alkemy.disneyAPI.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
}
