package com.example.reddit.services;


import com.example.reddit.models.Post;
import com.example.reddit.models.User;

import java.util.List;
import java.util.Optional;


public interface RedditService {

    List<Post> getPosts();

    Optional<Post> getPostById(String incomingId);

    void increaseLikes(String incomingId);

    void decreaseLikes(String incomingId);

    void addOrUpdatePost(Post post);

    List<Post> customQueryTopLikes();

    List<Post> findByTitleContainingOrUrlContaining(String search);

}
