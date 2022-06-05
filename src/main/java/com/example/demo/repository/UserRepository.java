package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public boolean existsByUsername(String username);

    public List<User> findByUsername(String username);

	@Query("select max(u.id) from User u")
    public Integer findMaxId();
	
	@Query("SELECT u from User u WHERE u.username= :username AND u.password= :password")
    public List<User> findByUser(
	@Param("username") String username, 
	@Param("password") String password);
}
