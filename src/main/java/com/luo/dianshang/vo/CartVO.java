package com.luo.dianshang.vo;

import lombok.Data;

/**
 * @author 南磊
 * @date 2020/5/22 11:15
 * @Description
 */
@Data
public class CartVO {
    private Integer id;
    private Integer quantity;
    private Float cost;
    //商品ID
    private Integer productId;
    private String name;
    private Float price;
    private String fileName;
    private Integer stock;
}
