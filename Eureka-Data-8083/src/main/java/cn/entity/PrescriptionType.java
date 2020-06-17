package cn.entity;

import java.io.Serializable;

public class PrescriptionType implements Serializable {
    private Integer id;
    private String tname;

    @Override
    public String toString() {
        return "PrescriptionType{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
