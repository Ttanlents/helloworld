package com.yjf.entity;

import java.util.Objects;

/**
 * @author 余俊锋
 * @date 2020/9/21 11:35
 * @Description
 */
public class Admin {
    private Integer id;
    private String name;
    private String password;

    public Admin(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Admin() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) &&
                Objects.equals(name, admin.name) &&
                Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
