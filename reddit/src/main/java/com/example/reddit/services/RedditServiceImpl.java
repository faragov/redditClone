package com.example.reddit.services;

import com.example.reddit.models.Post;
import com.example.reddit.repositories.RedditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RedditServiceImpl implements RedditService {

    private final RedditRepo redditRepo;

    @Autowired
    public RedditServiceImpl(RedditRepo redditRepo) {
        this.redditRepo = redditRepo;
    }

    @Override
    public List<Post> getPosts() {
        return redditRepo.findAll();
    }

    @Override
    public Optional<Post> getPostById(String incomingId) {
        Long id = Long.parseLong(incomingId);
        return redditRepo.findById(id);
    }


    @Override
    public void increaseLikes(String incomingId) {

        Optional<Post> foundPost = redditRepo.findById(Long.valueOf(incomingId));

        Post post = foundPost.get();
        post.setNumberOfLikes(post.getNumberOfLikes() + 1);
        redditRepo.save(post);
    }

    @Override
    public void decreaseLikes(String incomingId) {
        Optional<Post> foundPost = redditRepo.findById(Long.valueOf(incomingId));

        Post post = foundPost.get();
        post.setNumberOfLikes(post.getNumberOfLikes() - 1);
        redditRepo.save(post);
    }

    @Override
    public void addOrUpdatePost(Post post) {
        redditRepo.save(post);
    }

    @Override
    public List<Post> customQueryTopLikes() {
        return redditRepo.findTop3ByNumberOfLikes();
    }

    @Override
    public List<Post> findByTitleContainingOrUrlContaining(String search) {
        return redditRepo.findByTitleContainingOrUrlContaining(search);
    }

}
