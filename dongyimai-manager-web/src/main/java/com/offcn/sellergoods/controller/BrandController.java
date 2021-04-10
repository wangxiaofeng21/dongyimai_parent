package com.offcn.sellergoods.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.entity.PageResult;
import com.offcn.entity.Result;
import com.offcn.pojo.TbBrand;
import com.offcn.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
/*
* 1.接受请求,参数
* 2.调用业务
* 3.封装返回结果
* */
public class BrandController {

    @Reference
    private BrandService brandService;

    //查询所有
    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    //分页查询
    @RequestMapping("/findPage")
    public PageResult findPage(int page,int rows) {
        return brandService.findPage(page,rows);
    }

    //添加
    @RequestMapping("/addBrand")
    public Result addBrand(@RequestBody TbBrand brand) {//异步json
        try {
            brandService.addBrand(brand);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    //回显
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }

    //更新
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand) {
        try {
            brandService.update(brand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    //删除
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    //模糊查询
    @RequestMapping("/search")
    public PageResult search(int page, int rows,@RequestBody TbBrand brand) {
        return brandService.findPage(page,rows,brand);

    }


}
