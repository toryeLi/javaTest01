package com.entity;

import com.annotantion.PK;

public class Items {
    @PK
    private Integer id;//商品编号
    private String name;//商品名称
    private String city;//产地
    private Integer price; //价格
    private Integer number;//库存
    private String picture;//商品图片

    @Override
    public int hashCode() {
        return this.getId()+this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }
        if (obj instanceof Items) {
            Items items=(Items)obj;
            if(this.getId()==items.getId()&&this.getName()==items.getName()){
                return true;
            }else {
                return false;
            }
        }else {return false;}
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", picture='" + picture + '\'' +
                '}';
    }

    public Items() {
    }

    public Items(Integer id, String name, String city, Integer price, Integer number, String picture) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.price = price;
        this.number = number;
        this.picture = picture;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
