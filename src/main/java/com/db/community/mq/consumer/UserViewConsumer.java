package com.db.community.mq.consumer;


import com.db.community.model.entity.View;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.db.community.common.GlobalVars.VIEW_QUEUE;

@Component
@Slf4j
public class UserViewConsumer {

    @RabbitListener(queuesToDeclare = @Queue("userView.save"))
    public void saveUserView(View view) {
        VIEW_QUEUE.add(view);
    }
}
