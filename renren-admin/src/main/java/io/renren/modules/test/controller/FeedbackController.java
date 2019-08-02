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

import io.renren.modules.test.entity.FeedbackEntity;
import io.renren.modules.test.service.FeedbackService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 反馈信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-02 08:08:21
 */
@RestController
@RequestMapping("test/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("test:feedback:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = feedbackService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("test:feedback:info")
    public R info(@PathVariable("id") Integer id){
        FeedbackEntity feedback = feedbackService.getById(id);

        return R.ok().put("feedback", feedback);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("test:feedback:save")
    public R save(@RequestBody FeedbackEntity feedback){
        feedbackService.save(feedback);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test:feedback:update")
    public R update(@RequestBody FeedbackEntity feedback){
        ValidatorUtils.validateEntity(feedback);
        feedbackService.updateById(feedback);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test:feedback:delete")
    public R delete(@RequestBody Integer[] ids){
        feedbackService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
