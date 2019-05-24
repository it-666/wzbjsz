package com.wzb.applet.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 收藏
 */
@Data
public class UserCollectDO {

    private Long id;

    private Long userId;

    private Long articleId;

    private LocalDateTime issueTime;

}
