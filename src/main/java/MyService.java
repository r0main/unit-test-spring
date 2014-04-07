import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Romain on 07/04/14.
 */
@Component
public class MyService {

    @Resource
    private HelloService helloService;

    /**
     * Delegate to the hello service
     *
     * @return what helloService returns
     */
    public String getHello(){
        return helloService.getHello();
    }
}
