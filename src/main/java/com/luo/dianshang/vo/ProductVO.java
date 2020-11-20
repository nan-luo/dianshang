package com.luo.dianshang.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 南磊
 * @date 2020/5/19 12:05
 * @Description
 */
@Data
@AllArgsConstructor
public class ProductVO {
    private Integer id;
    private String name;
    private Float price;
    private String fileName;

}
