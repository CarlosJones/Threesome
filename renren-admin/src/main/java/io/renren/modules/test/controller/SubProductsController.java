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

import io.renren.modules.test.entity.SubProductsEntity;
import io.renren.modules.test.service.SubProductsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 子产品
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@RestController
@RequestMapping("test/subproducts")
public class SubProductsController {
    @Autowired
    private SubProductsService subProductsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("test:subproducts:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = subProductsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("test:subproducts:info")
    public R info(@PathVariable("id") Integer id){
        SubProductsEntity subProducts = subProductsService.getById(id);

        return R.ok().put("subProducts", subProducts);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("test:subproducts:save")
    public R save(@RequestBody SubProductsEntity subProducts){
        subProductsService.save(subProducts);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test:subproducts:update")
    public R update(@RequestBody SubProductsEntity subProducts){
        ValidatorUtils.validateEntity(subProducts);
        subProductsService.updateById(subProducts);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test:subproducts:delete")
    public R delete(@RequestBody Integer[] ids){
        subProductsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
