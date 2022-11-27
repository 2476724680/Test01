package userLogin;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class loginMethod {

    static final boolean USERNAME_EXIST=true;
    static final boolean USERNAME_ABSENCE=false;

    //登录功能
    public void login(Map<String, User> map) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String userName=sc.next();
        boolean flag=nameExist(map,userName);

    }

    //注册功能
    public void register(Map<String, User> map) {
        String userName=verifyName(map);
        verifyTelephoneNumber(map,userName);
        verifyIdCard(map,userName);
        verifyPassword(map,userName);
        System.out.println("用户注册成功");
    }


    //修改密码功能
    public void changePassWord(Map<String, User> map) {
      Scanner sc=new Scanner(System.in);
        String userName=sc.next();
        boolean flag=nameExist(map,userName);
        if(flag){
            System.out.println("请输入身份证号码");
            String idCardNumber=sc.next();
            if(idCardNumber.equals(map.get(userName).getIdCardNumber())){
                System.out.println("请输入手机号码");
                String telephoneNumber=sc.next();
                if(telephoneNumber.equals(map.get(userName).getTelephoneNumber())){
                    System.out.println("请输入修改密码");
                    String password=sc.next();
                    User user=map.get(userName);
                    user.setPassword(password);
                    System.out.println("修改密码成功");
                }else System.out.println("账号信息不匹配，修改失败");
            }else System.out.println("账号信息不匹配，修改失败");
        }
        else {
            System.out.println("用户未注册");
        }

    }

    //判断用户名是否存在
   public boolean nameExist(Map<String, User> map,String userName){
       Set<String> keySet=map.keySet();
       boolean flag=USERNAME_ABSENCE;
       for(String key:keySet){
           if(userName.equals(key)) {
               flag=USERNAME_EXIST;
               break;
           }
           else flag=USERNAME_ABSENCE;
       }
       return flag;
   }

    //判断用户名是否符合,并创建user对象，存入map中
    public String verifyName(Map<String, User> map) {
        System.out.println("请输入注册用户名（用户名长度必须在3~15位之间且只能是字母加数字的组合，但是不能是纯数字）");
        Scanner sc = new Scanner(System.in);
        String userName;
        //遍历看用户名是否唯一
        while (true) {
            userName = sc.next();
            if (map.isEmpty()) break;
            else {
                //得到map中的所有key并存放到集合中
                Set<String> keySet = map.keySet();
                for (String key : keySet) {
                    if (key.equals(userName))
                        System.out.println("用户名重复，请重新输入用户名");
                }
            }
        }

        //判断用户名是否满足命名要求
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{3,15}$";
        while (true) {
            if (userName.matches(regex)) break;
            else {
                System.out.println("用户名不满足命名要求，请重新输入");
                userName = sc.next();
            }
        }
        User user=new User();
        user.setName(userName);
        map.put(userName,user);
        System.out.println("用户名设置成功");
        return userName;
    }

    //手机号验证
    public void verifyTelephoneNumber(Map<String, User> map,String userName){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入手机号码");
        String regex="^[1-9][0-9]{10}$";
        String telephoneNumber;
        while(true){
            telephoneNumber=sc.next();
            if(telephoneNumber.matches(regex)) break;
            else System.out.println("手机号码不符合要求，请重新输入");
        }
        User user=map.get(userName);
        user.setTelephoneNumber(telephoneNumber);
        System.out.println("手机号码记录成功");
    }


    //身份证号码验证
    public void verifyIdCard(Map<String, User> map,String userName){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入身份证号码");
        String regex="^[1-9][0-9]{16}[0-9|x|X]$";
        String idCardNumber;
        while(true){
            idCardNumber=sc.next();
            if(idCardNumber.matches(regex)) break;
            else System.out.println("身份证号码不符合要求，请重新输入");
        }
        User user=map.get(userName);
        user.setIdCardNumber(idCardNumber);
        System.out.println("身份证号码记录成功");
    }

    //密码验证
    public void verifyPassword(Map<String, User> map,String userName){
        Scanner sc=new Scanner(System.in);
        String password1;
        while(true){
        System.out.println("请输入密码");
        password1=sc.next();
        System.out.println("请再次输入密码");
        String password2=sc.next();
        if(password1.equals(password2)) break;
        else System.out.println("两次密码不匹配，请重新输入");
        }
        User user=map.get(userName);
        user.setPassword(password1);
        System.out.println("密码记录成功");
    }
}
