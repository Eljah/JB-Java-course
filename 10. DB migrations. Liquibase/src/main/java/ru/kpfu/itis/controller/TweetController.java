package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.Comment;
import ru.kpfu.itis.model.Tweet;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.CommentRepository;
import ru.kpfu.itis.repository.TweetRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.TweetService;

import java.util.List;

@Controller
public class TweetController {

    @Autowired //FIXME BAD!! Almost
    UserRepository userRepository;

    @Autowired
    TweetService tweetService;

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping("/tweets/add")
    @ResponseStatus(HttpStatus.OK)
    public void addTweet(@RequestParam("text") String text) {
        User user=null;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch (java.lang.ClassCastException e)
        {
        }
        tweetService.addTweet(user, text);
    }

    @RequestMapping("/tweets/getAll")
    public String getAllTweetsPage(Model model) {
        //List<Tweet> tweets = tweetService.getAll();
        //model.addAttribute("tweets", tweets);
        //return "tweet-list";
        return "redirect:/tweets/pages/1";
    }

    @RequestMapping(value = "/tweets/pages/{pageNumber}", method = RequestMethod.GET)
    public String getTweetsPage(@PathVariable Integer pageNumber, Model model) {
        Page<Tweet> page = tweetService.getTweet(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());
        List<Tweet> tweets = page.getContent();
        model.addAttribute("total", page.getTotalPages());
        model.addAttribute("tweets", tweets);
        model.addAttribute("deploymentLog", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "tweet-list";
    }

    @RequestMapping("/tweets/{id}")
    public String getTweetComment(@PathVariable Long id, Model model) {
        Tweet tweet = tweetRepository.findOne(id);
        model.addAttribute("tweet", tweet);
        return "tweet";
    }
    @RequestMapping("/tweets/{tweetid}/comments/add")
    @ResponseStatus(HttpStatus.OK)
    public void addComment(@RequestParam("text") String text, @PathVariable("tweetid") Long tweetid) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment = new Comment();
        comment.setText(text);
        comment.setUser(user);
        comment.setTweet(tweetRepository.findOne(tweetid));
        commentRepository.save(comment);
    }
    @RequestMapping("/tweets/{id}/comments")
    public String getAllCommentsPage(@PathVariable Long id, Model model) {
        Tweet tweet = tweetRepository.findOne(id);
        List<Comment> comments = commentRepository.findByTweet(tweet);
        model.addAttribute("comments", comments);
        return "comment-list";


    }
}
