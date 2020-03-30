package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xgp
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private Integer id;
    private String cardName;
    private String cover;
    private String text;


}
