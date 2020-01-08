package com.ipanel.partymember.log;

import org.springframework.context.ApplicationEvent;

/**
 * @author liyu
 * @date 2019/11/5 14:41
 * @description 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(SysLog source) {
        super(source);
    }
}
