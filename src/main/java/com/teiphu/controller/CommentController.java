package com.teiphu.controller;

import com.teiphu.pojo.CommentDo;
import com.teiphu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:57
 **/
@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @PutMapping("saveComment")
    public String saveComment(CommentDo comment) {
        int res = commentService.addComment(comment);
        return "";
    }

    @ResponseBody
    @DeleteMapping("removeComment")
    public String removeComment(Integer commentId) {
        int res = commentService.deleteComment(commentId);
        return "";
    }

    @ResponseBody
    @PostMapping("changeComment")
    public String changeComment(CommentDo comment) {
        int res = commentService.updateComment(comment);
        return "";
    }

    @ResponseBody
    @GetMapping("retrieveComment")
    public CommentDo retrieveComment(Integer commentId) {
        CommentDo comment = commentService.getComment(commentId);
        return comment;
    }

    @ResponseBody
    @GetMapping("retrieveCommentsByParent")
    public List<CommentDo> retrieveCommentsByParent(Integer parentCommentId) {
        List<CommentDo> comments = commentService.listCommentByParent(parentCommentId);
        return comments;
    }

    @ResponseBody
    @GetMapping("retrieveCommentsByAnswer")
    public List<CommentDo> retrieveCommentsByAnswer(Integer answerId) {
        List<CommentDo> comments = commentService.listCommentByAnswer(answerId);
        return comments;
    }

    @ResponseBody
    @GetMapping("retrieveTopCommentsByAnswer")
    public List<CommentDo> retrieveTopCommentsByAnswer(Integer answerId) {
        List<CommentDo> comments = commentService.listTopCommentByAnswer(answerId);
        return comments;
    }

    @ResponseBody
    @GetMapping("retrieveComments")
    public List<CommentDo> retrieveComments() {
        List<CommentDo> comments = commentService.listComent();
        return comments;
    }
}
