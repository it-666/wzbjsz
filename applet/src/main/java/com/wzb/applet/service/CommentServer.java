package com.wzb.applet.service;

import com.wzb.applet.bean.CommentDO;
import com.wzb.applet.id.IdGenerator;
import com.wzb.applet.mapper.CommentMapper;
import com.wzb.applet.model.CommentModel;
import com.wzb.applet.model.CommentRequestModel;
import com.wzb.applet.tools.DateTimeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 评论
 */
@Service
public class CommentServer {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private IdGenerator idGenerator;
    /**
     * 查看评论
     * @param articleId
     * @return
     */
    public List<CommentModel> listComment(Long articleId){
        return commentMapper.listComment(articleId);
    }

    /**
     * 评论
     * @param commentRequestModel
     * @return
     */
    public Integer insertComment(CommentRequestModel commentRequestModel){
        if (Objects.isNull(commentRequestModel)){
            return null;
        }
        CommentDO commentDO = new CommentDO();
        Long id = idGenerator.getNextId();
        commentDO.setId(id);
        commentDO.setUserId(commentRequestModel.getUserId());
        commentDO.setArticleId(commentRequestModel.getArticleId());
        commentDO.setContent(commentRequestModel.getContent());
        commentDO.setRank(commentRequestModel.getRank());
        commentDO.setReplyId(commentRequestModel.getReplyId());
        commentDO.setIssueTime(DateTimeTool.millisToLocalDateTime(System.currentTimeMillis()));
        return commentMapper.insertComment(commentDO);
    }

}
