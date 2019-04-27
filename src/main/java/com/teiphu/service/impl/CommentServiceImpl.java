package com.teiphu.service.impl;

import com.teiphu.mapper.CommentMapper;
import com.teiphu.mapper.UpdownvoteMapper;
import com.teiphu.pojo.CommentDo;
import com.teiphu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:53
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UpdownvoteMapper voteMapper;

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int addComment(CommentDo comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int deleteComment(Integer commentId) {
        Integer res = commentMapper.deleteComment(commentId);
        voteMapper.deleteUpdownvoteByComment(commentId);
        return res;
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int updateComment(CommentDo comment) {
        return commentMapper.updateComment(comment);
    }

    @Override
    public CommentDo getComment(Integer commentId) {
        return commentMapper.getComment(commentId);
    }

    @Override
    public List<CommentDo> listCommentByParent(Integer parentCommentId) {
        return commentMapper.listCommentByParent(parentCommentId);
    }

    @Override
    public List<CommentDo> listCommentByAnswer(Integer answerId) {
        return commentMapper.listCommentByAnswer(answerId);
    }

    @Override
    public List<CommentDo> listTopCommentByAnswer(Integer answerId) {
        return commentMapper.listTopCommentByAnswer(answerId);
    }

    @Override
    public List<CommentDo> listComent() {
        return commentMapper.listComment();
    }
}
