package com.dayup.seckil.repository;

import com.dayup.seckil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  public User findByUsernameAndPassword(String username, String password);
}
