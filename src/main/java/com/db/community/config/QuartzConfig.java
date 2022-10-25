package com.db.community.config;


import com.db.community.crontasks.SaveToDBTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        //指定任务描述具体的实现类
        return JobBuilder.newJob(SaveToDBTask.class)
                // 指定任务的名称
                .withIdentity("save2DBJob")
                // 任务描述
                .withDescription("用于将缓存中的数据持久化到数据库")
                // 每次任务执行后进行存储
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {
        //创建触发器
        return TriggerBuilder.newTrigger()
                // 绑定工作任务
                .forJob(jobDetail())
                // 每隔 20 秒执行一次 job
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(20))
                .build();
    }
}
