package tests;
import org.junit.Test;
public class AllApiTesting extends ApiTesting{
    @Test
    public void ApiTestleri() {
        test01Post();//Create eder
        test02GetPositive();//Create edileni getirir
        test03GetNegative();//Yanlis getirme islemi gerceklestirir
        test06PutNegative();//Sunucu izin vermedigi icin update edemez
        test04DeletePositive();//Create edilen data'yı siler
        test05DeleteNegative();//Yanlıs data silmeye calisir ve silemez.
    }
}
