package Configuration.ConfigFactory;
import lombok.Data;
import Configuration.utils.WebDriverFactory;
@Data
public class WebConfig {
    private String baseurl;
    private WebDriverFactory.Browser browser;
}
