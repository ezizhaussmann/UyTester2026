package org.tester.b_object;

/**
 * @created : 17/03/2026,18:37,mar.
 **/
public class Demo {
    private String name;
    private  int  age;
    private String sex;
    private float  taille;

    public Demo(){

    }

    public Demo(String name, int age, String sex, float taille) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.taille = taille;
    }

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

    public Float getTaille() {
        return taille;
    }

    public void setTaille(Float taille) {
        this.taille = taille;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", taille=" + taille +
                '}';
    }
}
