package com.gupao.vip.homework.pattern.prototype.shallow;


import com.gupao.vip.homework.pattern.prototype.ChildBean;

public class ShallowBean implements Cloneable {
    private String name;
    private String password;
    private String url;
    private ChildBean childBean;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }

    public ChildBean getChildBean() {
        return childBean;
    }

    public void setChildBean( ChildBean childBean ) {
        this.childBean = childBean;
    }

    @Override
    public ShallowBean clone() throws CloneNotSupportedException {
        return ( ShallowBean ) super.clone();
    }
}
