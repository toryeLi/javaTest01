package com.config;

/**
 * 读取属性配置文件的单例实现
 */
public class PropertiesConfiguration {
    private static class Configuration{
        private static final com.config.PropertiesPlaceHolder3 CONFIG=new com.config.PropertiesPlaceHolder3();
    }
    public static com.config.PropertiesPlaceHolder3 getInstance(){
        return Configuration.CONFIG;
    }
}
