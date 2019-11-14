package com.hwh.kfr.model;


import java.io.Serializable;

/**
 * @description 下级信息类
 */
public class Inferior implements Serializable {

    private Integer id;
    private String phone;
    private String nikeName;

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    @Override
    public String toString() {
        return "Inferior{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
