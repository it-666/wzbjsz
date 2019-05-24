package com.wzb.applet.mapper;

import com.wzb.applet.bean.ArticleContentDO;
import com.wzb.applet.model.ArticleContentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleContentMapper {
    /**
     * 查看 文章
     * @param queryContent
     * @return
     */
    List<ArticleContentModel> listArticleContent(@Param("queryContent")String queryContent);

    /**
     * 查看单个文章
     * @param id
     * @return
     */
    ArticleContentModel getArticle(@Param("id") Long id);

    /**
     * 修改文章阅读数
     * @param readNumber
     * @param id
     * @return
     */
    int updateArticleReadNumber(@Param("readNumber")Long readNumber,@Param("id")Long id);

}
