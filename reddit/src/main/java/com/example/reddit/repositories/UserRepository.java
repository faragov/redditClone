package com.example.reddit.repositories;

import com.example.reddit.models.Post;
import com.example.reddit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
