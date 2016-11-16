package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.util.ArrayList;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String description;

    @Min(1)
    @Max(5)
    private int beds;

    @Min(1)
    @Max(4)
    private int baths;

    private int price;

    @Min(20)
    @Max(240)
    private Double squareMeters;

    @Min(0)
    @Max(1400)
    private int locationX;

    @Min(0)
    @Max(1000)
    private int locationY;

    private ArrayList<String> provinces;

    public long getId() {
        return id;
    }

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

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public int getX() {
        return locationX;
    }

    public void setX(int locationX) {
        this.locationX = locationX;
    }

    public int getY() {
        return locationY;
    }

    public void setY(int locationY) {
        this.locationY = locationY;
    }

    public ArrayList<String> getProvinces() {
        return provinces;
    }

    public void setProvinces(ArrayList<String> provinces) {
        this.provinces = provinces;
    }
}
