package com.qlangtech.tis.config;

import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

/**
 * @author: 百岁（baisui@qlangtech.com）
 * @create: 2023-08-07 17:39
 **/
public abstract class BasicConfig {
    public static final int LogFlumeAddressPORT = 41414;
    /**
     * 可在环境变量中设置，当启动flink JOB MANAGER时候 可以重新定义 Config 从本地加载的资源的classpath路径
     */
    public static final String KEY_ENV_TIS_CFG_BUNDLE_PATH = "tisCfgBundlePath";

    // 组装节点
    protected abstract String getAsbHost();

    public abstract Map<String, String> getAllKV();

    private static BasicConfig baseConfig;

    public static BasicConfig getBaseConfig() {
        if (baseConfig == null) {
            ServiceLoader<BasicConfig> configLoader = ServiceLoader.load(BasicConfig.class);
            for (BasicConfig conf : configLoader) {
                baseConfig = conf;
                break;
            }
        }
        return Objects.requireNonNull(baseConfig, "baseConfig can not be null");
    }

    public static String getAssembleHost() {
        return getBaseConfig().getAsbHost();
    }


}
