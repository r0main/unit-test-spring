import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.*;

/**
 * This test class does not use mocks
 *
 * Created by Romain on 07/04/14.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyAppConfig.class})
public class MyServiceTest {

    @Resource MyService myService;

    @Test
    public void testGetHelloMock1(){
        // use the default implementation FrenchHello
        String result = myService.getHello();
        Assert.assertEquals("Bonjour",result);
    }
}
