package com.db.community.aop;

import com.db.community.common.api.ResponseEntity;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.utils.SingleKeyVOFactory;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SingleKeyVOAspect {

    @Pointcut("@annotation(com.db.community.aop.annotation.SingleKeyVORecycle)")
    public void SingleKeyVOPointcut() {}

    @AfterReturning(returning = "rep", pointcut = "SingleKeyVOPointcut()")
    public void afterReturning(ResponseEntity<SingleKeyVO> rep) {
        SingleKeyVOFactory.recycleVO(rep.getData());
    }
}
