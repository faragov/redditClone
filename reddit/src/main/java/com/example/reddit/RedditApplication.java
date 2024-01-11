package com.example.reddit;

import com.example.reddit.models.Post;
import com.example.reddit.models.User;
import com.example.reddit.repositories.RedditRepo;
import com.example.reddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditApplication implements CommandLineRunner {

    private final RedditRepo redditRepo;
    private final UserRepository userRepository;


    @Autowired
    public RedditApplication(RedditRepo redditRepo, UserRepository userRepository) {
        this.redditRepo = redditRepo;
        this.userRepository = userRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(RedditApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

      /*  User firstUser = new User();
        firstUser.setName("Milka");

        userRepository.save(firstUser);

        Post work = new Post();
        work.setTitle("It work");

        redditRepo.save(work);

        Post polish = new Post();
        polish.setTitle("It polish");

        redditRepo.save(polish);

        Post motion = new Post();
        motion.setTitle("It motion");

        redditRepo.save(motion);

        Post sign = new Post();
        sign.setTitle("It sign");

        redditRepo.save(sign);*/
    }
}
