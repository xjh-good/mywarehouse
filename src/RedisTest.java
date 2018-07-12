import java.util.HashSet;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class RedisTest {
	public static void main(String[] args) {

		// 测试redis集群
		HashSet<HostAndPort> hashSet = new HashSet<>();
		hashSet.add(new HostAndPort("192.168.1.128", 7000));
		hashSet.add(new HostAndPort("192.168.1.128", 7001));
		hashSet.add(new HostAndPort("192.168.1.128", 7002));
		hashSet.add(new HostAndPort("192.168.1.129", 7003));
		hashSet.add(new HostAndPort("192.168.1.129", 7004));
		hashSet.add(new HostAndPort("192.168.1.129", 7005));
		JedisCluster jedisCluster = new JedisCluster(hashSet);
		jedisCluster.set("duan", "100");
		String kString = jedisCluster.get("name");
		System.out.println(kString);

		// 测试单例redis
		// String host = "192.168.186.128";
		// int port = 6379;
		// Jedis jedis = null;
		// try {
		// jedis = new Jedis(host, port);
		// jedis.auth("123456");
		// jedis.set("name", "123");
		// String name = jedis.get("name");
		// System.out.println("name = " + name);
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// if (null != jedis) {
		// try {
		// jedis.close();
		// } catch (Exception e) {
		// System.out.println("redis连接关闭失败");
		// e.printStackTrace();
		// }
		// }
		// }
	}
}
