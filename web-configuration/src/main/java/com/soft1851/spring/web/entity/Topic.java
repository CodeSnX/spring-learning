package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xgp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topic {
    private String id;
    private String topicName;
    private String topicIcon;
    private String description;
    private Integer followerCount;
    private Integer msgCount;
    private Boolean followed;
}
