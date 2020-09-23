package com.xiaomi.pojo;

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
public class OrdersBody implements Serializable {
    private static final long serialVersionUID = -7319549840693353577L;
    private Integer ordersId;
    private Integer count;
}
