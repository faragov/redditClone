package com.example.reddit.controllers;

import com.example.reddit.models.Post;
import com.example.reddit.models.User;
import com.example.reddit.services.RedditService;
import com.example.reddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedditController {

    private final RedditService redditService;


    @Autowired
    public RedditController(RedditService redditService) {
        this.redditService = redditService;

    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("posts", redditService.customQueryTopLikes());

        return "index";
    }

    @GetMapping("/moreposts")
    public String morePost(Model model) {

        model.addAttribute("posts", redditService.getPosts());

        return "moreposts";
    }

    @GetMapping("/submit")

    public String submit(Model model) {

        return "submit";
    }

    @PostMapping("/submit")
    public String save(@ModelAttribute Post post) {

        redditService.addOrUpdatePost(post);

        return "redirect:/";
    }

    @GetMapping("/upload")
    public String increaseLikes(@RequestParam String postId) {

        redditService.increaseLikes(postId);

        return "redirect:/";
    }

    @GetMapping("/download")
    public String decreaseLikes(@RequestParam String postId) {

        redditService.decreaseLikes(postId);

        return "redirect:/";
    }

    @PostMapping("/contains")
    public String Contains(@RequestParam String search, Model model) {

        model.addAttribute("posts", redditService.findByTitleContainingOrUrlContaining(search));

        return "index";
    }


}
