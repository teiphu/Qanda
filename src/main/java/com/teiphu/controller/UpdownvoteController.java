package com.teiphu.controller;

import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.UpdownvoteDo;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.UpdownvoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:58
 **/
@Api(tags = "投票控制器")
@RestController
@RequestMapping("updownvote")
public class UpdownvoteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdownvoteController.class);

    @Autowired
    private UpdownvoteService voteService;

    @ApiOperation("保存投票")
    @PostMapping("saveVote")
    public String saveVote(HttpSession session, Integer commentId, Integer answerId, Integer senderId,
                           Integer receiverId, Integer upOrDown) {
        UserDo user = (UserDo) session.getAttribute("user");
        Integer userId = user.getId();
        if (upOrDown.intValue() == 0) {
            voteService.deleteVoteByAnswerAndUser(answerId, userId);
        } else {
            UpdownvoteDo vote = voteService.getVoteByAnswerAndUser(answerId, userId);
            if (vote == null) {
                UserDo receiver = new UserDo();
                receiver.setId(receiverId);
                AnswerDo answer = new AnswerDo();
                answer.setId(answerId);
                UpdownvoteDo voteDo = null;
                if (upOrDown.intValue() == 1) {
                    voteDo = new UpdownvoteDo(answer, user, receiver, 1);
                } else if (upOrDown.intValue() == 2) {
                    voteDo = new UpdownvoteDo(answer, user, receiver, 0);
                }
                int res = voteService.addVote(voteDo);
            } else {
                if (upOrDown == 2) {
                    vote.setUpOrDown(0);
                } else {
                    vote.setUpOrDown(1);
                }
                voteService.updateVote(vote);
            }
        }
        /*UpdownvoteDo vote = new UpdownvoteDo();
        vote.setComment(new CommentDo(commentId));
        vote.setAnswer(new AnswerDo(answerId));
        vote.setSender(new UserDo(senderId));
        vote.setReceiver(new UserDo(receiverId));
        vote.setUpOrDown(upOrDown);
        int res = voteService.addVote(vote);*/
        return "";
    }

    /*@ApiOperation("保存投票")
    @PostMapping("saveVote")
    public String saveVote(Integer commentId, Integer answerId, Integer senderId,
                           Integer receiverId, Integer upOrDown) {
        UpdownvoteDo vote = new UpdownvoteDo();
        vote.setComment(new CommentDo(commentId));
        vote.setAnswer(new AnswerDo(answerId));
        vote.setSender(new UserDo(senderId));
        vote.setReceiver(new UserDo(receiverId));
        vote.setUpOrDown(upOrDown);
        int res = voteService.addVote(vote);
        return "";
    }*/

    @ApiOperation("删除投票")
    @DeleteMapping("removeVote")
    public String removeVote(Integer voteId) {
        int res = voteService.deleteVote(voteId);
        return "";
    }

    @ApiOperation("修改投票")
    @Update("changeVote")
    public String changeVote(Integer voteId, Integer upOrDown) {
        UpdownvoteDo vote = new UpdownvoteDo();
        vote.setId(voteId);
        vote.setUpOrDown(upOrDown);
        int res = voteService.updateVote(vote);
        return "";
    }

    @ApiOperation("检索投票")
    @GetMapping("retrieveVote")
    public UpdownvoteDo retrieveVote(Integer voteId) {
        UpdownvoteDo vote = voteService.getVote(voteId);
        return vote;
    }

    @ApiOperation("检索所有投票")
    @GetMapping("retrieveVotes")
    public List<UpdownvoteDo> retrieveVotes() {
        List<UpdownvoteDo> votes = voteService.listVote();
        return votes;
    }

    @ApiOperation("按答案检索所有顶票")
    @GetMapping("retrieveUpvotesByAnswer")
    public List<UpdownvoteDo> retrieveUpvotesByAnswer(Integer answerId) {
        List<UpdownvoteDo> upvotes = voteService.listUpvoteByAnswer(answerId);
        return upvotes;
    }

    @ApiOperation("按评论检索所有顶票")
    @GetMapping("retrieveUpvotesByComment")
    public List<UpdownvoteDo> retrieveUpvotesByComment(Integer commentId) {
        List<UpdownvoteDo> upvotes = voteService.listUpvoteByComment(commentId);
        return upvotes;
    }

    @ApiOperation("按答案检索所有顶票数")
    @GetMapping("countUpvoteByAnswer")
    public Integer countUpvoteByAnswer(Integer answerId) {
        Integer num = voteService.countUpvoteByAnswer(answerId);
        return num;
    }

    @ApiOperation("按答案检索所有踩票数")
    @GetMapping("countDownvoteByAnswer")
    public Integer countDownvoteByAnswer(Integer answerId) {
        Integer num = voteService.countDownvoteByAnswer(answerId);
        return num;
    }

    @ApiOperation("按评论检索所有顶票数")
    @GetMapping("countUpvoteByComment")
    public Integer countUpvoteByComment(Integer commentId) {
        Integer num = voteService.countUpvoteByComment(commentId);
        return num;
    }

    @ApiOperation("按评论检索所有踩票数")
    @GetMapping("countDownvoteByComment")
    public Integer countDownvoteByComment(Integer commentId) {
        Integer num = voteService.countDownvoteByComment(commentId);
        return num;
    }
}
