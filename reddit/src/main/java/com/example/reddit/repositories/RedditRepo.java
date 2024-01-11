package com.example.reddit.repositories;

import com.example.reddit.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface RedditRepo extends JpaRepository<Post, Long> {


    @Query(value = "SELECT * FROM reddit.post ORDER BY number_of_likes DESC LIMIT 3", nativeQuery = true)
    List<Post> findTop3ByNumberOfLikes();


    @Query(value = "SELECT post FROM Post post WHERE post.title LIKE %:search% OR post.url LIKE %:search%")
    List<Post> findByTitleContainingOrUrlContaining(String search);


}
