import config.DisposableBean;
import config.InitializingBean;

/**
 * @author Kevin
 * @Description
 */
public class UserService implements InitializingBean, DisposableBean {
    private String uid;
    private UserDao userDao;
    private String location;
    private String company;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public UserService(){

    }


    @Override
    public String toString() {
        return super.toString();
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息" + location+company);
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

    @Override
    public void destroy() throws Exception {
        System.out.println("执行UserService：destroy");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("执行UserService.afterPropertiesSet");
    }
}
