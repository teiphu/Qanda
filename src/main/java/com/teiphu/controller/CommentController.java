package com.teiphu.controller;

import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.CommentDo;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:57
 **/
@Api(tags = "评论控制器")
@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("保存评论")
    @PutMapping("saveComment")
    public String saveComment(Integer parentCommentId, Integer userId, Integer answerId, String commentContent) {
        CommentDo comment = new CommentDo();
        comment.setParentCommentId(parentCommentId);
        comment.setUser(new UserDo(userId));
        comment.setAnswer(new AnswerDo(answerId));
        comment.setCommentContent(commentContent);
        int res = commentService.addComment(comment);
        return "";
    }

    @ApiOperation("删除评论")
    @DeleteMapping("removeComment")
    public String removeComment(Integer commentId) {
        int res = commentService.deleteComment(commentId);
        return "";
    }

    @ApiOperation("修改评论")
    @PostMapping("changeComment")
    public String changeComment(Integer commentId, String commentContent) {
        CommentDo comment = new CommentDo();
        comment.setId(commentId);
        comment.setCommentContent(commentContent);
        int res = commentService.updateComment(comment);
        return "";
    }

    @ApiOperation("检索评论")
    @GetMapping("retrieveComment")
    public CommentDo retrieveComment(Integer commentId) {
        CommentDo comment = commentService.getComment(commentId);
        return comment;
    }

    @ApiOperation("检索子评论")
    @GetMapping("retrieveCommentsByParent")
    public List<CommentDo> retrieveCommentsByParent(Integer parentCommentId) {
        List<CommentDo> comments = commentService.listCommentByParent(parentCommentId);
        return comments;
    }

    @ApiOperation("按答案检索评论")
    @GetMapping("retrieveCommentsByAnswer")
    public List<CommentDo> retrieveCommentsByAnswer(Integer answerId) {
        List<CommentDo> comments = commentService.listCommentByAnswer(answerId);
        return comments;
    }

    @ApiOperation("检索答案的最上层评论")
    @GetMapping("retrieveTopCommentsByAnswer")
    public List<CommentDo> retrieveTopCommentsByAnswer(Integer answerId) {
        List<CommentDo> comments = commentService.listTopCommentByAnswer(answerId);
        return comments;
    }

    @ApiOperation("检索所有评论")
    @GetMapping("retrieveComments")
    public List<CommentDo> retrieveComments() {
        List<CommentDo> comments = commentService.listComent();
        return comments;
    }
}
