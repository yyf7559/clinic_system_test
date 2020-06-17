package cn.entity;

import java.io.Serializable;


public class Disease implements Serializable {
    private Integer id;
    private String diseaseName;

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", diseaseName='" + diseaseName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
}
