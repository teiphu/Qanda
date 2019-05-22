package com.teiphu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.CommentDo;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    @PostMapping("saveComment")
    public String saveComment(HttpSession session, Integer parentCommentId, Integer answerId, String commentContent) {
        UserDo user = (UserDo) session.getAttribute("user");
        CommentDo comment = new CommentDo();
        comment.setParentCommentId(parentCommentId);
        comment.setUser(user);
        comment.setAnswer(new AnswerDo(answerId));
        comment.setCommentContent(commentContent);
        int res = commentService.addComment(comment);
        return "";
    }

    @ResponseBody
    @ApiOperation("删除评论")
    @PostMapping("removeComment")
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

    @ResponseBody
    @GetMapping("listCommentByPaging")
    public JSONObject listCommentByPaging(String searchText, Integer page, Integer limit) {
        int count = 0;
        List<CommentDo> comments = null;
        if (!StringUtils.isEmpty(searchText)) {
            comments = commentService.listCommentBySearch(searchText, page, limit);
            count = commentService.countCommentBySearch(searchText);
        } else {
            comments = commentService.listComentPaging(page, limit);
            count = commentService.countComment();
        }
        JSONObject res = new JSONObject();
        res.put("code", 0);
        res.put("count", count);
        res.put("msg", "");
        JSONArray quesJA = new JSONArray();
        quesJA.addAll(comments);
        res.put("data", quesJA);
        return res;
    }
}
