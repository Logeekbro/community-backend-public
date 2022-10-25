package com.db.community.crontasks;

import com.db.community.service.ActionService;
import com.db.community.service.CountService;
import com.db.community.service.ViewService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class SaveToDBTask extends QuartzJobBean {

    @Resource
    private CountService countService;

    @Resource
    private ViewService viewService;

    @Resource
    private ActionService actionService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        viewService.saveToDB();
        countService.saveCacheToDB();
        actionService.saveLikeCountToDB();
        actionService.saveLikeRelationToDB();
    }
}
