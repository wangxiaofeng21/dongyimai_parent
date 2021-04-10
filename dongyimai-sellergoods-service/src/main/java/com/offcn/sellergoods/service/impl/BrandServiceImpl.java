package com.offcn.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.entity.PageResult;
import com.offcn.mapper.TbBrandMapper;
import com.offcn.pojo.TbBrand;
import com.offcn.pojo.TbBrandExample;
import com.offcn.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;

    //查找所有
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    //分页查询
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);//select * from brand
        return new PageResult(page.getResult(), page.getTotal());
    }

    //添加
    public void addBrand(TbBrand brand) {
       brandMapper.insert(brand);
    }

    //回显
    public TbBrand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    //更新
    public void update(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    //删除
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    //模糊查询
    public PageResult findPage(int pageNum, int pageSize, TbBrand brand) {
        PageHelper.startPage(pageNum, pageSize);
        TbBrandExample example=new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if(brand!=null){
            if(brand.getName()!=null && brand.getName().length()>0){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }
        Page<TbBrand> page= (Page<TbBrand>)brandMapper.selectByExample(example);
        return new PageResult(page.getResult(), page.getTotal());
    }


}
