package tests;
import baseUrl.BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.*;
import pojos.PetYokPojo;
import pojos.StoreOrderPojo;
import static io.restassured.RestAssured.*;
public class ApiTesting extends BaseUrl {
    @Test
    public void test01Post() {
        spec.pathParams("first","store","second","order");
        StoreOrderPojo expectedDataObje=new StoreOrderPojo(12,13,2,"2022-07-28T11:30:51.000+0000","placed",true);
        Response response=given().spec(spec).when().contentType(ContentType.JSON).body(expectedDataObje).when().post("/{first}/{second}");
        StoreOrderPojo actualDataObje=response.as(StoreOrderPojo.class);
        Assert.assertEquals(actualDataObje.getPetId(),expectedDataObje.getPetId());
        Assert.assertEquals(actualDataObje.getId(),expectedDataObje.getId());
        Assert.assertEquals(actualDataObje.getComplete(),expectedDataObje.getComplete());
        Assert.assertEquals(actualDataObje.getShipDate(),expectedDataObje.getShipDate());
        Assert.assertEquals(actualDataObje.getStatus(),expectedDataObje.getStatus());
        System.out.println("Istenen data olusturuldu...");
    }
    @Test
    public void test02GetPositive() {
        spec.pathParams("first","store","second","order","third",12);
        StoreOrderPojo expectedDataObje=new StoreOrderPojo(12,13,2,"2022-07-28T11:30:51.000+0000","placed",true);
        Response response=given().spec(spec).when().contentType(ContentType.JSON).when().get("/{first}/{second}/{third}");
        response.then().assertThat().statusCode(200);
        StoreOrderPojo actualDataObje=response.as(StoreOrderPojo.class);
        Assert.assertEquals(actualDataObje.getPetId(),expectedDataObje.getPetId());
        Assert.assertEquals(actualDataObje.getId(),expectedDataObje.getId());
        Assert.assertEquals(actualDataObje.getComplete(),expectedDataObje.getComplete());
        Assert.assertEquals(actualDataObje.getShipDate(),expectedDataObje.getShipDate());
        Assert.assertEquals(actualDataObje.getStatus(),expectedDataObje.getStatus());
        System.out.println("Istenen data ile gercek data eslesti...");
    }
    @Test
    public void test03GetNegative() {
        spec.pathParams("first","store","second","order","third",999);
        PetYokPojo expectedDataObje=new PetYokPojo(1,"error","Pet not found");
        Response response=given().spec(spec).when().contentType(ContentType.JSON).when().get("/{first}/{second}/{third}");
        response.then().assertThat().statusCode(404);
        PetYokPojo actualDataObje=response.as(PetYokPojo.class);
        System.out.println("Istenenilen data ile gercek data uyusmadi...");
    }
    @Test
    public void test04DeletePositive() {
        spec.pathParams("first","store","second","order","third",12);
        Response response=
                given().spec(spec).when().delete("/{first}/{second}/{third}");
        response.then().assertThat().statusCode(200);
        PetYokPojo expectedDataObje=new PetYokPojo(200,"unknown","12");
        PetYokPojo actualDataObje=        response.as(PetYokPojo.class);
        Assert.assertEquals(actualDataObje.getCode(),expectedDataObje.getCode());
        Assert.assertEquals(actualDataObje.getType(),expectedDataObje.getType());
        Assert.assertEquals(actualDataObje.getMessage(),expectedDataObje.getMessage());
        System.out.println("Istenen data silindi...");

    }
    @Test
    public void test05DeleteNegative() {
        spec.pathParams("first","store","second","order","third",999);
        Response response=
                given().spec(spec).when().delete("/{first}/{second}/{third}");
        response.then().assertThat().statusCode(404);
        PetYokPojo expectedDataObje=new PetYokPojo(404,"unknown","Order Not Found");
        PetYokPojo actualDataObje=        response.as(PetYokPojo.class);
        Assert.assertEquals(actualDataObje.getCode(),expectedDataObje.getCode());
        Assert.assertEquals(actualDataObje.getType(),expectedDataObje.getType());
        Assert.assertEquals(actualDataObje.getMessage(),expectedDataObje.getMessage());
        System.out.println("Istenen data silinemedi cunku data bulunamadi...");

    }
    @Test
    public void test06PutNegative() {
        spec.pathParams("first","store","second","order","third",12);
        StoreOrderPojo expectedDataObje=new StoreOrderPojo(12,26,6,"2022-07-28T11:30:51.000+0000","placed",false);
        Response response=given().spec(spec).when().contentType(ContentType.JSON).body(expectedDataObje).when().put("/{first}/{second}/{third}");
        response.then().assertThat().statusCode(405);
        System.out.println("Kaynak kabul etmedigi icin 'put' yapilamadi...");

    }
}
