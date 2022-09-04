package com.chowyijiu.springboot.bean;

public class User {

    private String name;

    private Integer age;

    private Cat cat;

    public User(String name, Integer age, Cat cat) {
        this.name = name;
        this.age = age;
        this.cat = cat;
    }

    public User() {

    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cat=" + cat +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
