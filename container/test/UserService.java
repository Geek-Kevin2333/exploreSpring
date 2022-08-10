/**
 * @author Kevin
 * @Description
 */
public class UserService {
    private String name;
    public UserService(){

    }


    @Override
    public String toString() {
        return super.toString();
    }

    public UserService(String name){
        this.name = name;
    }
    public void queryUserInfo(){
        System.out.println("查询用户信息"+name);
    }
}
