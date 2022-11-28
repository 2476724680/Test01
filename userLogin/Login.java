package userLogin;

import informationCheck.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    public void login(){
        Scanner sc=new Scanner(System.in);
        loginMethod lM=new loginMethod();
        Map<String ,User> map=new HashMap<String,User>();
        loop:while(true){
        System.out.println("---欢迎来到学生管理系统登录界面---");
        System.out.println("请选择操作");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.忘记密码");
        System.out.println("4.退出");
        String str=sc.next();
        switch (str){
            case "1":lM.login(map);break;
            case "2":lM.register(map);break;
            case "3":lM.changePassWord(map);break;
            case "4":System.out.println("退出成功");
                break loop;
            default:
                System.out.println("错误操作");
        }
        }
    }

    public static void main(String[] args) {
        Login login=new Login();
        login.login();
    }

}
