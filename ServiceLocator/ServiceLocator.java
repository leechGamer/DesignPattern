import javax.naming.InitialContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/*
* cache라는 Map 객체에 home 객체를 찾은 결과를 보관하고 있다가
* 누군가 그 객체를 필요로 할 때 메모리에서 찾아서 제공하도록 되어 있다.
* 만약 해당 객체가 cache라는 맵에 없으면 메모리에서 찾는다.
* */
public class ServiceLocator {
    private InitialContext ic;
    private Map cache;
    private static ServiceLocator me;
    static {
        me = new ServiceLocator();
    }
    
    private ServiceLocator() {
        cache = Collections.synchronizedMap(new HashMap<>());
    }
    
    public InitialContext getInitialContext() throws Exception {
        try {
            if (ic == null) {
                ic = new InitialContext();
            }
        } catch (Exception e) {
            throw e;
        }
        return ic;
    }
    
    public static ServiceLocator getInstance() {
        return me;
    }
}
