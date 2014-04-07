import org.springframework.stereotype.Component;

/**
 * Created by Romain on 07/04/14.
 */
@Component
public class FrenchHello implements HelloService {

    @Override
    public String getHello() {
        return "Bonjour";
    }
}
