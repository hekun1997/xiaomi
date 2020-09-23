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
    private Integer color_id;
    private Integer goods_id;
    private String color_name;
    private String rgb;
}
