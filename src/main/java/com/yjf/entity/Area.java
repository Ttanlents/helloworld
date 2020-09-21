package com.yjf.entity;

import java.util.Objects;

/**
 * @author 余俊锋
 * @date 2020/9/21 17:25
 * @Description
 */
public class Area {
    private Integer id;
    private String name;
    private String paraentId;
    private Integer type;

    public Area() {
    }

    public Area(Integer id, String name, String paraentId, Integer type) {
        this.id = id;
        this.name = name;
        this.paraentId = paraentId;
        this.type = type;
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

    public String getParaentId() {
        return paraentId;
    }

    public void setParaentId(String paraentId) {
        this.paraentId = paraentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(id, area.id) &&
                Objects.equals(name, area.name) &&
                Objects.equals(paraentId, area.paraentId) &&
                Objects.equals(type, area.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, paraentId, type);
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", paraentId='" + paraentId + '\'' +
                ", type=" + type +
                '}';
    }
}

