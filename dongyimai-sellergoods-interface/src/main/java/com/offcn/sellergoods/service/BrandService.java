package com.offcn.sellergoods.service;

import com.offcn.entity.PageResult;
import com.offcn.pojo.TbBrand;

import java.util.List;

public interface BrandService {

    public List<TbBrand> findAll();

    public PageResult findPage(int pageNum,int pageSize);

    public void addBrand(TbBrand brand);

    public TbBrand findOne(Long id);

    public void update(TbBrand brand);

    public void delete(Long[] ids);

    public PageResult findPage(int pageNum,int pageSize,TbBrand brand);


}
