import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author daixunan
 * @date 2018/9/8
 */

public class Jredis {
    public static void main(String[] args) {
        Jedis j = new Jedis("140.143.230.219", 6379);
//        j.set("name", "dxn");
//        j.set("age", "28");
        List<String> age = j.mget("age");
        for (String out : age) {
            System.out.println("out = " + out);
        }

        Map<String, String> map = new HashMap();
//        map.put("name", "wyx");
//        map.put("age", "26");
//        map.put("haokan", "yes");
//
//        j.hmset("wyx", map);
//        List<String> wyx = j.hmget("wyx", "name", "age", "haokan");
//        System.out.println("wyx = " + wyx);
        final String USER_AGE_28 = "USER_AGE_28";
        final String USER_DXN = "USER_DXN3";
        final String USER_TABLE = "USER_TABLE";

        User u1 = new User(UUID.randomUUID().toString(), "dxn1", 28);
        j.sadd(USER_AGE_28, u1.getId());
        User u2 = new User(UUID.randomUUID().toString(), "dxn2", 29);
        User u3 = new User(UUID.randomUUID().toString(), "dxn3", 28);
        j.sadd(USER_AGE_28, u3.getId());
        j.sadd(USER_DXN, u3.getId());
        User u4 = new User(UUID.randomUUID().toString(), "dxn3", 31);
        j.sadd(USER_DXN, u4.getId());
        User u5 = new User(UUID.randomUUID().toString(), "dxn3", 32);
        j.sadd(USER_DXN, u5.getId());

        User u6 = new User(UUID.randomUUID().toString(), "dxn6", 33);
        User u7 = new User(UUID.randomUUID().toString(), "dxn7", 34);

        map.put(u1.getId(), JSON.toJSONString(u1));
        map.put(u2.getId(), JSON.toJSONString(u2));
        map.put(u3.getId(), JSON.toJSONString(u3));
        map.put(u4.getId(), JSON.toJSONString(u4));
        map.put(u5.getId(), JSON.toJSONString(u5));
        map.put(u6.getId(), JSON.toJSONString(u6));
        map.put(u7.getId(), JSON.toJSONString(u7));
        j.hmset(USER_TABLE, map);

    }
}
