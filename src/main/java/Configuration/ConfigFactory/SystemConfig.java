package Configuration.ConfigFactory;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;

public class SystemConfig {
    private volatile Config config;
    private volatile WebConfig webConfig;
    private ApiConfig apiConfig;

    private SystemConfig(){
        config = ConfigFactory.parseResources("test.conf");
    }

    public synchronized WebConfig getWebConfig(){
        if(webConfig == null){
            webConfig = ConfigBeanFactory.create(config,WebConfig.class);
        }
        return webConfig;
    }

    public synchronized ApiConfig getApiConfig(){
        if(apiConfig == null){
            apiConfig = ConfigBeanFactory.create(config,ApiConfig.class);
        }
        return apiConfig;
    }

    public synchronized static SystemConfig getInstance(){
        return new SystemConfig();
    }


}
