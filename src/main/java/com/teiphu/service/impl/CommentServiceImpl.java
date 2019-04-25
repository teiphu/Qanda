package com.teiphu.service.impl;

import com.teiphu.mapper.CommentMapper;
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

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int addComment(CommentDo comment) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int deleteComment(Integer commentId) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int updateComment(CommentDo comment) {
        return 0;
    }

    @Override
    public CommentDo getComment(Integer commentId) {
        return null;
    }

    @Override
    public List<CommentDo> listCommentByParent(Integer parentCommentId) {
        return null;
    }

    @Override
    public List<CommentDo> listCommentByAnswer(Integer answerId) {
        return null;
    }

    @Override
    public List<CommentDo> listTopCommentByAnswer(Integer answerId) {
        return null;
    }

    @Override
    public List<CommentDo> listComent() {
        return null;
    }
}
