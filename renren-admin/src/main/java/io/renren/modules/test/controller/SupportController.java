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

import io.renren.modules.test.entity.SupportEntity;
import io.renren.modules.test.service.SupportService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 服务
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@RestController
@RequestMapping("test/support")
public class SupportController {
    @Autowired
    private SupportService supportService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("test:support:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = supportService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("test:support:info")
    public R info(@PathVariable("id") Integer id){
        SupportEntity support = supportService.getById(id);

        return R.ok().put("support", support);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("test:support:save")
    public R save(@RequestBody SupportEntity support){
        supportService.save(support);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test:support:update")
    public R update(@RequestBody SupportEntity support){
        ValidatorUtils.validateEntity(support);
        supportService.updateById(support);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test:support:delete")
    public R delete(@RequestBody Integer[] ids){
        supportService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
