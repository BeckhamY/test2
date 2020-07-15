import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class Demo1 {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.59.130", 6380);
//        System.out.println("connection test --->" + jedis.ping());

        // Set
        Set<String> keys = jedis.keys("*");
//        for(Iterator iterator=keys.iterator(); iterator.hasNext();) {
//            String str = (String) iterator.next();
//            System.out.println(str);
//        }
        for(String item : keys) {
            System.out.println(item);
        }
        System.out.println("jedis.exists ---> " + jedis.exists("k2"));
        System.out.println(jedis.ttl("k1"));

        // String
        // jedis.append("k1", "myredis");
        System.out.println(jedis.get("k1"));
        jedis.set("k6", "v6");
        System.out.println("------------------------");
        jedis.mset("k7", "v7", "k8", "v8");
        System.out.println(jedis.mget("k7", "k8"));

    }

}
