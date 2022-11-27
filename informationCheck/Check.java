package informationCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        checkMethod cM=new checkMethod();
        List<Student> list=new ArrayList<Student>();
        //首界面
        loop:while (true) {
            System.out.println("-----欢迎来到学生查询系统-----");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入你的选择");
            String str = sc.next();
            //通过switch调用不同的方法
            switch (str) {
                case "1": cM.addStudent(list);break;
                case "2": cM.deleteStudent(list);break;
                case "3": cM.changeStudent(list);break;
                case "4":cM.checkStudent(list);break;
                case "5": {
                    System.out.println("退出成功");
                    break loop;
                }
            }
        }
    }
}
