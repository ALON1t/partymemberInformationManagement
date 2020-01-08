package com.ipanel.partymember.log;

import com.ipanel.partymember.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import com.ipanel.partymember.pojo.SysLog;

/**
 * @author liyu
 * @date 2019/11/5 14:40
 * @description
 */
@Slf4j
@Component
public class SysLogListener {

    @Autowired
    private SysLogService sysLogService;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        SysLog sysLog = (SysLog) event.getSource();
        // 保存日志
        sysLogService.save(sysLog);
    }
}

