package com.xiaomi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hekun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color implements Serializable {
    private static final long serialVersionUID = -9118123792094348087L;
    private Integer colorId;
    private Integer goodsId;
    private String colorName;
    private String rgb;
}
