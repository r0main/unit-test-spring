import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Romain on 07/04/14.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyServiceInjectingMocksTest.MyServiceTestConfig.class, MyAppConfig.class})
public class MyServiceInjectingMocksTest {

    @Resource HelloService mockHelloService;

    @Resource MyService myService;

    @After
    public void afterTest(){
        //reset mock info because spring keep the mock instance "in cache".
        // If you delete this test "verifyGetHelloAskTheHelloService" will fail.
        reset(mockHelloService);
    }

    @Test
    public void testGetHelloMock1(){
        when(mockHelloService.getHello()).thenReturn("Hi I'm a mock");
        String result = myService.getHello();
        assertEquals("Hi I'm a mock", result);
    }

    @Test
    public void verifyGetHelloAskTheHelloService(){
        String result = myService.getHello();
        verify(mockHelloService).getHello();
        verifyNoMoreInteractions(mockHelloService);
    }

    static class MyServiceTestConfig{
        /**
         * @Primary indicates Spring to use this bean in priority to the one that is component-scanned
         */
        @Bean
        @Primary
        public HelloService getHelloService(){
            return mock(HelloService.class);
        }
    }
}
