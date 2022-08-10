/**
 * @author Kevin
 * @Description
 */
public class PlayerService {
    private String uid;
    private UserDao userDao;

    public void queryPlayerInfo() {
        System.out.println("playerService" + userDao.queryUserName(uid));
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
