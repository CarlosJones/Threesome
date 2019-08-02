package io.renren.modules.test.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.test.entity.ProductsEntity;
import io.renren.modules.test.service.ProductsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 产品
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@RestController
@RequestMapping("test/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("test:products:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("test:products:info")
    public R info(@PathVariable("id") Integer id){
        ProductsEntity products = productsService.getById(id);

        return R.ok().put("products", products);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("test:products:save")
    public R save(@RequestBody ProductsEntity products){
        productsService.save(products);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test:products:update")
    public R update(@RequestBody ProductsEntity products){
        ValidatorUtils.validateEntity(products);
        productsService.updateById(products);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test:products:delete")
    public R delete(@RequestBody Integer[] ids){
        productsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
