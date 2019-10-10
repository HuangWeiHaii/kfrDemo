package com.hwh.kfr.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {


    private Integer id;
    private String nikeName;
    private String username;
    private String password;
    private String idcard;
    private String phone;

    //主要数据 一对一 id-mid
    private MainData mainData;

    private Integer superiors_id;
    //下级列表 一对多  id- 多个 superiors_id
    private List<Inferior> inferior;

    //认证状态  0 未认证 1 已认证
    private Integer certifiedStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MainData getMainData() {
        return mainData;
    }

    public void setMainData(MainData mainData) {
        this.mainData = mainData;
    }

    public Integer getSuperiors_id() {
        return superiors_id;
    }

    public void setSuperiors_id(Integer superiors_id) {
        this.superiors_id = superiors_id;
    }

    public List<Inferior> getInferior() {
        return inferior;
    }

    public void setInferior(List<Inferior> inferior) {
        this.inferior = inferior;
    }

    public Integer getCertifiedStatus() {
        return certifiedStatus;
    }

    public void setCertifiedStatus(Integer certifiedStatus) {
        this.certifiedStatus = certifiedStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nikeName='" + nikeName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", idcard=" + idcard +
                ", phone='" + phone + '\'' +
                ", mainData=" + mainData +
                ", superiors_id=" + superiors_id +
                ", inferior=" + inferior +
                ", CertifiedStatus=" + certifiedStatus +
                '}';
    }
}
