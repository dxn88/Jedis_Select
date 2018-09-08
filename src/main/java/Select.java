import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultXMLDocumentHandler;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author daixunan
 * @date 2018/9/9
 */

public class Select {
    public static void main(String[] args) {
        Jedis j = new Jedis("140.143.230.219", 6379);
        final String USER_AGE_28 = "USER_AGE_28";
        final String USER_DXN = "USER_DXN3";
        final String USER_TABLE = "USER_TABLE";

//        Set<String> age28 = j.smembers(USER_AGE_28);
//        System.out.println("age28 = " + age28);
//        Set<String> dxn = j.smembers(USER_DXN);
        Set<String> sinter = j.sinter(USER_AGE_28, USER_DXN);
        for (String userStr : sinter) {
            String userJson = j.hget(USER_TABLE, userStr);
            JSONObject jsonObject = JSON.parseObject(userJson);
            User userObj = JSON.toJavaObject(jsonObject, User.class);
            System.out.println("user1 = " + userObj);

        }

//        System.out.println("dxn = " + dxn);


    }
}
