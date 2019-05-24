package com.wzb.applet.mapper;

import com.wzb.applet.bean.UserCollectDO;
import com.wzb.applet.model.ArticleContentModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserCollectMapper {
    /**
     * 新增
     * @param userCollectDO
     */
    void insertUserCollect(UserCollectDO userCollectDO);


    List<ArticleContentModel> listArticleContentSearchContent(@Param("userId")Long userId, @Param("queryContent")String queryContent);

    /**
     * 查看单个文章
     * @param userId
     * @param id
     * @return
     */
    ArticleContentModel getArticle(@Param("userId")Long userId,@Param("id") Long id);
}
