package com.wzb.applet.mapper;

import com.wzb.applet.bean.CommentDO;
import com.wzb.applet.model.CommentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {
    /**
     * 查看
     * @param articleId
     * @return
     */
    List<CommentModel> listComment(@Param("articleId")Long articleId);

    /**
     * 新增
     * @param commentRequestModel
     * @return
     */
    int insertComment(CommentDO commentDO);

}
