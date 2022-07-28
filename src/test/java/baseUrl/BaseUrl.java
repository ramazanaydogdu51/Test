package baseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
public class BaseUrl {
    protected RequestSpecification spec;
      @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/").build();
    }
}
