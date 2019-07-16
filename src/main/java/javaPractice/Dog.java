package javaPractice;

/**
 * Created by 祁连山 on 2019/6/5.
 */
public class Dog {
    public String color;
    int age;
    String name;
    Dog(String name, int age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }
    public void sayName() {
        System.out.println("My Name is " + name);
    }
}
