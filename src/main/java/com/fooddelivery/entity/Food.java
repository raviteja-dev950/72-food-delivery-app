package com.fooddelivery.entity;
import jakarta.persistence.*;

@Entity
@Table(name="foods")
public class Food {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String city;
    private String type;
    private Double price;
    @Column(length=1000) private String imageUrl;
    @Column(length=1000) private String description;
    private String restaurantName;
    private Long ownerId;

    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getTitle(){return title;} public void setTitle(String t){title=t;}
    public String getCity(){return city;} public void setCity(String c){city=c;}
    public String getType(){return type;} public void setType(String t){type=t;}
    public Double getPrice(){return price;} public void setPrice(Double p){price=p;}
    public String getImageUrl(){return imageUrl;} public void setImageUrl(String i){imageUrl=i;}
    public String getDescription(){return description;} public void setDescription(String d){description=d;}
    public String getRestaurantName(){return restaurantName;} public void setRestaurantName(String r){restaurantName=r;}
    public Long getOwnerId(){return ownerId;} public void setOwnerId(Long o){ownerId=o;}
}