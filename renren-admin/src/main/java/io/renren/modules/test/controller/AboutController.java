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

import io.renren.modules.test.entity.AboutEntity;
import io.renren.modules.test.service.AboutService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 关于
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@RestController
@RequestMapping("test/about")
public class AboutController {
    @Autowired
    private AboutService aboutService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("test:about:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = aboutService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("test:about:info")
    public R info(@PathVariable("id") Integer id){
        AboutEntity about = aboutService.getById(id);

        return R.ok().put("about", about);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("test:about:save")
    public R save(@RequestBody AboutEntity about){
        aboutService.save(about);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test:about:update")
    public R update(@RequestBody AboutEntity about){
        ValidatorUtils.validateEntity(about);
        aboutService.updateById(about);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test:about:delete")
    public R delete(@RequestBody Integer[] ids){
        aboutService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
