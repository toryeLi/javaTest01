package util.jdbc.datasource;

/**
 * 线程池单例类，多线程百分百安全
 */
public class DataSourcePooledManager {
    private static class DataSourcePoolGet{
        public static final util.jdbc.datasource.AbstractDataSourcePooled instance=new util.jdbc.datasource.DataSourcePooled();
    }
    public static util.jdbc.datasource.AbstractDataSourcePooled getInstance(){
        return DataSourcePoolGet.instance;
    }
}
