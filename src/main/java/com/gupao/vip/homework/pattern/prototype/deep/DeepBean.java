package com.gupao.vip.homework.pattern.prototype.deep;


import com.gupao.vip.homework.pattern.prototype.ChildBean;

import java.io.*;

public class DeepBean implements Serializable {
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

    public DeepBean deepClone() {
        DeepBean o = null;
        try ( ByteArrayOutputStream out = new ByteArrayOutputStream();
              ObjectOutputStream obs = new ObjectOutputStream( out ) ) {
            obs.writeObject( this );
            try (
                    ByteArrayInputStream in = new ByteArrayInputStream( out.toByteArray() );
                    ObjectInputStream ois = new ObjectInputStream( in ) ) {
                o = ( DeepBean ) ois.readObject();
            } catch ( IOException | ClassNotFoundException e ) {
                e.printStackTrace();
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        return o;
    }
}
