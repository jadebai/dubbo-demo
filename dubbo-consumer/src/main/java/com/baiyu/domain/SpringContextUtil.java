package com.baiyu.domain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * FileName: com.baiyu.domain.SpringContextUtil
 * Author: baiyu
 * Date: 2018/6/9 0009
 * Description: spring 上下文获取 此类必须交给spring管理
 *              当spring加载实例化完成对象以后
 *              会调用setApplicationContext 把上下文复制到此类中
 * History:
 * <Author>      <Time>    <version>    <desc>
 * baiyu   下午 10:33    1.0       Create
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据类名称获取对象
     *
     * @param name
     * @return
     */
    public static Object getBeanByName(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 根据class获取对象
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBeanByClass(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 根据名称和class获取对象
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBeanByNameAndClass(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
