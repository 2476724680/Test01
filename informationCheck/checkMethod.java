package informationCheck;

import java.util.List;
import java.util.Scanner;

public class checkMethod {
    static final int ID_ABSENCE=-1;
    //添加功能
    public void addStudent(List<Student> list) {
        String id;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生id");

        while (true) {
            id = sc.next();
            //判断id是否唯一
            boolean flag = checkId(id, list);
            if (flag) break;
            else
                System.out.println("id存在，请重新输入");
        }

        System.out.println("请输入学生姓名");
        String name = sc.next();
        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        System.out.println("请输入学生家庭住址");
        String address = sc.next();
        Student stu = new Student(id, name, age, address);
        list.add(stu);
    }

    //删除功能
    public void deleteStudent(List<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你想要删除的学生id");
        int index;
        while (true) {
            String id = sc.next();
            //两种情况:id存在与不存在
            index = checkIdExist(id, list);
            if (index!=ID_ABSENCE) break;
            else System.out.println("id不存在，请重新输入id");
        }
        list.remove(index);
        System.out.println("删除成功");
    }

    //修改功能
    public void changeStudent(List<Student> list) {
       Scanner sc=new Scanner(System.in);
       System.out.println("请输入你想要修改的学生信息的id");
       String id=sc.next();
       int index=checkIdExist(id,list);
       if(index==ID_ABSENCE)
           System.out.println("该id不存在");
       else {
           System.out.println("请输入你想修改的姓名");
           String name=sc.next();
           System.out.println("请输入你想修改的年龄");
           int age=sc.nextInt();
           System.out.println("请输入你想修改的家庭住址");
           String address=sc.next();
           Student stu=list.get(index);
           stu.setName(name);
           stu.setAge(age);
           stu.setAddress(address);
           System.out.println("信息修改成功");
       }
    }

    //查询功能
    public void checkStudent(List<Student> list) {
        //没有学生信息和有学生信息两种情况
        if (list.isEmpty()) System.out.println("当前无学生信息，请添加后查询");
        else {
            System.out.println("id\t" + "\t" + "姓名\t" + "\t" + "年龄\t" + "\t" + "家庭住址");
            for (Student s : list) {
                System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getAddress() + "\t");
            }
        }
    }


    //检查id是否唯一
    public boolean checkId(String id, List<Student> list) {
        if (list.isEmpty()) return true;
        else {
            for (Student s : list) {
                if (s.getId().equals(id))
                    return false;
            }
        }
        return true;
    }


    //判断id是否存在
    public int checkIdExist(String id, List<Student> list) {
        if (list.isEmpty()) return ID_ABSENCE;
        else {
            for(int i=0;i< list.size();i++){
                if(list.get(i).getId().equals(id)){
                    return i;
                }
            }
        }
        return ID_ABSENCE;
    }
}