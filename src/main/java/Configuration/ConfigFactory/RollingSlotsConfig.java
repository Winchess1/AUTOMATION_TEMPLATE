package Configuration.ConfigFactory;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;

public class RollingSlotsConfig {
    private volatile Config config;
    private volatile WebConfig webConfig;

    private RollingSlotsConfig(){
        config = ConfigFactory.systemProperties()
                .withFallback((ConfigFactory.systemEnvironment()))
                .withFallback((ConfigFactory.parseResources("test.conf")));
    }

    public synchronized WebConfig getWebConfig(){
        if(webConfig == null){
            webConfig = ConfigBeanFactory.create(config,WebConfig.class);
        }
        return webConfig;
    }

    public synchronized static RollingSlotsConfig getInstance(){
        return new RollingSlotsConfig();
    }

}
