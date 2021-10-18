package com.example.appdroid.ui.about;

public class BranchModel {

    private int img, img2;
    private String title, description;

    public BranchModel(int img, String title, String description,int img2){
        this.img=img;
        this.img2=img2;
        this.title= title;
        this.description= description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) { this.img2 = img2; }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
