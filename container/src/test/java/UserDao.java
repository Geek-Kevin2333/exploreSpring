import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @Description
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "user1");
        hashMap.put("10002", "user2");
        hashMap.put("10003", "user3");
    }

    public String queryUserName(String uid){
        return hashMap.get(uid);
    }

}
