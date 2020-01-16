package com.hyf.mvc.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class User {

    @NotBlank
    private String name;

    @NotNull(message ="{msg.notnull}")
    private Integer age;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date birthday;

    @NumberFormat(pattern = "#,###,###.#")
    private Double price;

    private User user;

    public User(){}

    public User(String name){this.name = name;}

    public User(String name, Integer age, Date birthday, Double price) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.price = price;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
