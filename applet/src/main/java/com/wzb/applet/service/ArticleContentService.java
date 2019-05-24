package com.wzb.applet.service;

import com.wzb.applet.model.ArticleByIdModel;
import com.wzb.applet.model.ArticleContentModel;
import com.wzb.applet.mapper.ArticleContentMapper;
import com.wzb.applet.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ArticleContentService {
    @Autowired
    private ArticleContentMapper articleContentMapper;
    @Autowired
    private CommentServer commentServer;

    /**
     * 查看 与搜索
     * @param searchContent
     * @return
     */
    public List<ArticleContentModel> listArticleContent(String searchContent){
        return articleContentMapper.listArticleContent(searchContent);
    }

    /**
     * 查看文章
     * @param id
     * @return
     */
    public ArticleByIdModel getArticle(Long id){
        ArticleByIdModel articleById = new ArticleByIdModel();
        ArticleContentModel articleContent = articleContentMapper.getArticle(id);
        if(Objects.isNull(articleContent)){
            return null;
        }
        // 浏览数 加 1
        Long readNumber = articleContent.getReadNumber() + 1;
        articleContentMapper.updateArticleReadNumber(readNumber,id);
        List<CommentModel> listUserCollect = commentServer.listComment(articleContent.getId());
        articleById.setArticleContent(articleContent);
        if(Objects.nonNull(listUserCollect)){
            articleById.setListComment(listUserCollect);
        }
        return articleById;
    }
}
