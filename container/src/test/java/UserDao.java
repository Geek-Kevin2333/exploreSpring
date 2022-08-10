import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @Description
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1001", "user1");
        hashMap.put("1002", "user2");
        hashMap.put("1003", "user3");
    }

    public String queryUserName(String uid){
        return hashMap.get(uid);
    }

}
