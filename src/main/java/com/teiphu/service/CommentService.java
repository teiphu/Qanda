package com.teiphu.service;

import com.teiphu.pojo.CommentDo;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:51
 **/
public interface CommentService {

    int addComment(CommentDo comment);

    int deleteComment(Integer commentId);

    int updateComment(CommentDo comment);

    CommentDo getComment(Integer commentId);

    List<CommentDo> listCommentByParent(Integer parentCommentId);

    List<CommentDo> listCommentByAnswer(Integer answerId);

    List<CommentDo> listTopCommentByAnswer(Integer answerId);

    List<CommentDo> listComent();

    List<CommentDo> listComentPaging(Integer page, Integer limit);

    int countComment();

    List<CommentDo> listCommentBySearch(String searchText, Integer page, Integer limit);

    int countCommentBySearch(String searchText);
}
