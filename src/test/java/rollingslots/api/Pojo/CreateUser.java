package rollingslots.api.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUser {
    private String login;
    private String password;
    private String token;
}
//public class steps {
//    @JsonProperty("id")
//    private int id;
//    @JsonProperty("doc_id")
//    private String doc_id;
//    @JsonProperty("level_name")
//    private String level_name;
//    @JsonProperty("exchange_rate")
//    private ArrayList exchange_rate;
//
//}
//@JsonDeserialize(using=)
//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd'T'hh:mm:ss.SSSZ")
//private LocalDataTime createAt;
