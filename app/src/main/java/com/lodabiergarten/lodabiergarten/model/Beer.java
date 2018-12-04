package com.lodabiergarten.lodabiergarten.model;

public class Beer {

    private String name;
    private String image_url;
    private String rating;
    private String description;


    public Beer() {}

    public Beer(String name, String description, String rating) {
        this.name = name;
        this.rating = rating;
        this.description = description;
    }


  /*  public Beer(String name, String image_url, String rating) {
        this.name = name;
        this.image_url = image_url;
        this.rating = rating;
      //  this.description = description;
    }
*/
    public String getDescription() {return description;}

    public String getBeerName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getRating() {
        return rating;
    }

    public void setBeerName(String name) {
        this.name = name;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {this.description = description; }





}
