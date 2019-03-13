package com.gupao.vip.homework.pattern.prototype;

import java.io.Serializable;

public class ChildBean implements Serializable {
    private String childName;

    public String getChildName() {
        return childName;
    }

    public void setChildName( String childName ) {
        this.childName = childName;
    }
}
