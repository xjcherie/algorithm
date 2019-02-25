package practice;

import java.lang.reflect.Field;

/**
 * create by cherie on 2018/8/7.
 */
class Person {

    private String name;

    private int age;

    private String sex;

    //还可以有很多属性，可以看出，如果单个输出每个属性，势必是非常麻烦的！
    //对应的getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String args[]) throws Exception {
        //预先生成一个p1对象
        Person p1 = new Person();
        p1.setName("Jefferson");
        p1.setAge(23);
        p1.setSex("male");
        //再生成一个p2对象
        Person p2 = new Person();
        p2.setName("wangminli");
        p2.setAge(24);
        p2.setSex("famale");

        //使用反射技术完成对象属性的输出
        Field[] fields = p1.getClass().getDeclaredFields();

        for (Field f : fields) {
            f.setAccessible(true);
        }
        //输出p1的所有属性
        System.out.println("=============About p1===============");
        for (Field f : fields) {
            String field = f.toString().substring(f.toString().lastIndexOf(".") + 1);            //取出属性名称
            System.out.println("p1." + field + " --> " + f.get(p1));
        }
        //同上输出p2所有属性
        System.out.println("=============About p2===============");
        for (Field f : fields) {
            String field = f.toString().substring(f.toString().lastIndexOf(".") + 1);            //取出属性名称
            System.out.println("p2." + field + " --> " + f.get(p2));
        }

    }
}
