package com.teiphu.controller;

import com.teiphu.pojo.UpdownvoteDo;
import com.teiphu.service.UpdownvoteService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:58
 **/
@RestController
@RequestMapping("updownvote")
public class UpdownvoteController {

    @Autowired
    private UpdownvoteService voteService;

    @ResponseBody
    @PutMapping("saveVote")
    public String saveVote(UpdownvoteDo vote) {
        int res = voteService.addVote(vote);
        return "";
    }

    @ResponseBody
    @DeleteMapping("removeVote")
    public String removeVote(Integer voteId) {
        int res = voteService.deleteVote(voteId);
        return "";
    }

    @ResponseBody
    @Update("changeVote")
    public String changeVote(UpdownvoteDo vote) {
        int res = voteService.updateVote(vote);
        return "";
    }

    @ResponseBody
    @GetMapping("retrieveVote")
    public UpdownvoteDo retrieveVote(Integer voteId) {
        UpdownvoteDo vote = voteService.getVote(voteId);
        return vote;
    }

    @ResponseBody
    @GetMapping("retrieveVotes")
    public List<UpdownvoteDo> retrieveVotes() {
        List<UpdownvoteDo> votes = voteService.listVote();
        return votes;
    }

    @ResponseBody
    @GetMapping("retrieveUpvotesByAnswer")
    public List<UpdownvoteDo> retrieveUpvotesByAnswer(Integer answerId) {
        List<UpdownvoteDo> upvotes = voteService.listUpvoteByAnswer(answerId);
        return upvotes;
    }

    @ResponseBody
    @GetMapping("retrieveUpvotesByComment")
    public List<UpdownvoteDo> retrieveUpvotesByComment(Integer commentId) {
        List<UpdownvoteDo> upvotes = voteService.listUpvoteByComment(commentId);
        return upvotes;
    }

    @ResponseBody
    @GetMapping("countUpvoteByAnswer")
    public Integer countUpvoteByAnswer(Integer answerId) {
        Integer num = voteService.countUpvoteByAnswer(answerId);
        return num;
    }

    @ResponseBody
    @GetMapping("countDownvoteByAnswer")
    public Integer countDownvoteByAnswer(Integer answerId) {
        Integer num = voteService.countDownvoteByAnswer(answerId);
        return num;
    }

    @ResponseBody
    @GetMapping("countUpvoteByComment")
    public Integer countUpvoteByComment(Integer commentId) {
        Integer num = voteService.countUpvoteByComment(commentId);
        return num;
    }

    @ResponseBody
    @GetMapping("countDownvoteByComment")
    public Integer countDownvoteByComment(Integer commentId) {
        Integer num = voteService.countDownvoteByComment(commentId);
        return num;
    }
}
