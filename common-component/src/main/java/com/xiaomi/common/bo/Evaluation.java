package com.xiaomi.common.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hekun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation implements Serializable {
    private static final long serialVersionUID = -7776698202322763502L;
    private Integer evaluationId;
    private Integer userId;
    private Integer goodsId;
    private String evaluationDetail;
    private Integer evaluationStar;
}