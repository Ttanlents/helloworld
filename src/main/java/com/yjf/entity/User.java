package com.yjf.entity;

import java.io.Serializable;

import java.util.Objects;

/**
 * @author 余俊锋
 * @date 2020/9/9 17:23
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Double sal;
    private String birth;
    private String createTime;

    public User() {
    }

    public User(Integer id, String name, Integer age, String sex, Double sal, String birth, String createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.sal = sal;
        this.birth = birth;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(age, user.age) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(sal, user.sal) &&
                Objects.equals(birth, user.birth) &&
                Objects.equals(createTime, user.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex, sal, birth, createTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", sal=" + sal +
                ", birth='" + birth + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
