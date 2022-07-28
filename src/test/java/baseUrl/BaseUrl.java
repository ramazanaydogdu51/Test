package baseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrl {
    protected RequestSpecification spec;
    //kodlari ufak ufak parcalayip bolmek atomic structure(atomik yapi)
    // @Before annotation'ı kullandığımız methodlar her  Test metodondan önce çalıştırılır.
    @Before//her test method'undan once calissin diye
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/").build();
    }
}
//https://petstore.swagger.io/v2