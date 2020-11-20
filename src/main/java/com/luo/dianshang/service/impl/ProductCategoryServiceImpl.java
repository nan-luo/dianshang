package com.luo.dianshang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luo.dianshang.entity.Product;
import com.luo.dianshang.entity.ProductCategory;
import com.luo.dianshang.mapper.ProductCategoryMapper;
import com.luo.dianshang.mapper.ProductMapper;
import com.luo.dianshang.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luo.dianshang.vo.ProductCategoryVO;
import com.luo.dianshang.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 花折
 * @since 2020-05-18
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductCategoryVO> getAllProductCategoryVO() {
        //一级分类
        QueryWrapper wrapper=new QueryWrapper();
        //当type==1时
        wrapper.eq("type",1);
        List<ProductCategory> levelOne=productCategoryMapper.selectList(wrapper);
        //转为vo
        List<ProductCategoryVO> levelOneVo=levelOne.stream()
                .map(e -> new ProductCategoryVO(e.getId(),e.getName()))
                .collect(Collectors.toList());

        //图片赋值
        //商品信息赋值
        for (int i=0;i<levelOneVo.size();i++){
            levelOneVo.get(i).setBannerImg("/images/banner"+i+".png");
            levelOneVo.get(i).setTopImg("/images/top"+i+".png");
            wrapper=new QueryWrapper();
            wrapper.eq("categorylevelone_id",levelOneVo.get(i).getId());
            List<Product> productList=productMapper.selectList(wrapper);
            List<ProductVO> productVOList=productList.stream()
                    .map(e -> new ProductVO(
                            e.getId(),
                            e.getName(),
                            e.getPrice(),
                            e.getFileName()
                    )).collect(Collectors.toList());
            levelOneVo.get(i).setProductVOList(productVOList);
        }

        for (ProductCategoryVO levelOneProductCategoryVO : levelOneVo) {
            wrapper=new QueryWrapper();
            wrapper.eq("type",2);
            wrapper.eq("parent_id",levelOneProductCategoryVO.getId());
            List<ProductCategory> levelTwo=productCategoryMapper.selectList(wrapper);
            List<ProductCategoryVO> levelTwoVo=levelTwo.stream()
                    .map(e -> new ProductCategoryVO(e.getId(),e.getName()))
                    .collect(Collectors.toList());
            //将two装到one中
            levelOneProductCategoryVO.setChildren(levelTwoVo);

            for (ProductCategoryVO levelTwoProductCategoryVO : levelTwoVo) {
                wrapper=new QueryWrapper();
                wrapper.eq("type",3);
                wrapper.eq("parent_id",levelTwoProductCategoryVO.getId());
                List<ProductCategory> levelThree=productCategoryMapper.selectList(wrapper);
                List<ProductCategoryVO> levelThreeVo=levelThree.stream()
                        .map(e ->new ProductCategoryVO(e.getId(),e.getName())).collect(Collectors.toList());
                levelTwoProductCategoryVO.setChildren(levelThreeVo);
            }
        }
        return levelOneVo;
    }
}
