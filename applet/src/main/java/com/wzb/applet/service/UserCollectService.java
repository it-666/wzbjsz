package com.wzb.applet.service;

import com.wzb.applet.bean.UserCollectDO;
import com.wzb.applet.id.IdGenerator;
import com.wzb.applet.mapper.ArticleContentMapper;
import com.wzb.applet.mapper.UserCollectMapper;
import com.wzb.applet.model.ArticleByIdModel;
import com.wzb.applet.model.ArticleContentModel;
import com.wzb.applet.model.CommentModel;
import com.wzb.applet.model.UserCollectModel;
import com.wzb.applet.tools.DateTimeTool;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Log4j
public class UserCollectService {
    @Autowired
    private UserCollectMapper userCollectMapper;
    @Autowired
    private ArticleContentMapper articleContentMapper;
    @Autowired
    private CommentServer commentServer;
    @Autowired
    private IdGenerator idGenerator;

    /**
     * 收藏
     * @param userCollectModel
     */
    public void insertUserCollect(UserCollectModel userCollectModel){
        if (Objects.isNull(userCollectModel)){
            log.warn("UserCollectModel is NULL");
            return;
        }
        UserCollectDO userCollectDO = new UserCollectDO();
        Long id = idGenerator.getNextId();
        userCollectDO.setId(id);
        userCollectDO.setUserId(userCollectModel.getUserId());
        userCollectDO.setArticleId(userCollectModel.getArticleId());
        userCollectDO.setIssueTime(DateTimeTool.millisToLocalDateTime(System.currentTimeMillis()));
        userCollectMapper.insertUserCollect(userCollectDO);
    }

    /**
     * 查看收藏
     * @param userId
     * @param searchContent
     * @return
     */
    public List<ArticleContentModel> listArticleContent(Long userId, String searchContent){
        return userCollectMapper.listArticleContentSearchContent(userId,searchContent);
    }
    /**
     * 查看文章
     * @param id
     * @param userId
     * @return
     */
    public ArticleByIdModel getArticle(Long userId,Long id){
        if (Objects.isNull(userId) && Objects.isNull(id)){
            log.warn("userID and ID is NULL");
            return null;
        }
        ArticleByIdModel articleById = new ArticleByIdModel();
        ArticleContentModel articleContent = userCollectMapper.getArticle(userId,id);
        List<CommentModel> listUserCollect = commentServer.listComment(articleContent.getId());
        articleById.setArticleContent(articleContent);
        // 浏览数 加 1
        Long readNumber = articleContent.getReadNumber() + 1;
        articleContentMapper.updateArticleReadNumber(readNumber,id);
        if(Objects.nonNull(listUserCollect)){
            articleById.setListComment(listUserCollect);
        }
        return articleById;
    }

}
