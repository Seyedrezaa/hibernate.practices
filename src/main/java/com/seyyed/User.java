package com.seyyed;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "info")
    @Basic
    private String info;
    @Column(name = "code")
    @Basic
    private String code;

    public User() {
    }

    public User(String info, String code, Long id) {
        this.id = id;
        this.info = info;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String user) {
        this.info = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "user info is: ".concat(info);
    }
}
