package Configuration.ConfigFactory;
import lombok.Data;
import Configuration.utils.WebDriverFactory;
@Data
public class WebConfig {
    private String baseUrl;
    private WebDriverFactory.Browser browser;
}
