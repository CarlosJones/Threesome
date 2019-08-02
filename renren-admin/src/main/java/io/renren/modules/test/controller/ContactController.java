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

import io.renren.modules.test.entity.ContactEntity;
import io.renren.modules.test.service.ContactService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 联系
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@RestController
@RequestMapping("test/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("test:contact:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = contactService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("test:contact:info")
    public R info(@PathVariable("id") Integer id){
        ContactEntity contact = contactService.getById(id);

        return R.ok().put("contact", contact);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("test:contact:save")
    public R save(@RequestBody ContactEntity contact){
        contactService.save(contact);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test:contact:update")
    public R update(@RequestBody ContactEntity contact){
        ValidatorUtils.validateEntity(contact);
        contactService.updateById(contact);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test:contact:delete")
    public R delete(@RequestBody Integer[] ids){
        contactService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
