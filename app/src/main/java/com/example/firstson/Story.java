package com.example.firstson;

import java.util.Date;

public class Story {
    private String nameStory;
    private int imgStory;
    private Date updateDate;
    private int idStory;

    public Story(String nameStory, int imgStory, Date updateDate, int idStory) {
        this.nameStory = nameStory;
        this.imgStory = imgStory;
        this.updateDate = updateDate;
        this.idStory = idStory;
    }

    public String getNameStory() {
        return nameStory;
    }

    public void setNameStory(String nameStory) {
        this.nameStory = nameStory;
    }

    public int getImgStory() {
        return imgStory;
    }

    public void setImgStory(int imgStory) {
        this.imgStory = imgStory;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getIdStory() {
        return idStory;
    }

    public void setIdStory(int idStory) {
        this.idStory = idStory;
    }
}
