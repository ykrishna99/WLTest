import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    -JUnit Test.
    -When you run it will check code is working as expected and generate coverage report.
 */
public class ScrappingServiceTest {

    ScrappingService scrappingService;

    @Before
    public void setUp(){
        scrappingService = new ScrappingService();
    }

    @Test
    public void testScrape(){
        String resultMessage = scrappingService.doScrape();
        Assert.assertEquals("scrapping done successfully", resultMessage);
    }
}
