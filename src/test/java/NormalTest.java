import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Optional;

/**
 * @description:
 * @author: suyue
 * @time: 2021/5/29 15:51
 */
public class NormalTest {

    @Test
    public void optionalTest() {
        //调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("Sanaulla");
        //传入参数为null，抛出NullPointerException.
//        Optional<String> someNull = Optional.of(null);
        System.out.println(JSON.toJSONString(name));
        String a = "name";
        System.out.println(a);

        Optional.ofNullable("a");

    }

}
