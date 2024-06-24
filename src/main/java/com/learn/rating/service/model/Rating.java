package com.learn.rating.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private double avgrateing;
    private  Long count;

    public Rating() {
    }

    public Rating(Long id, String name, double avgrateing, Long count) {
        this.id = id;
        this.name = name;
        this.avgrateing = avgrateing;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgrateing() {
        return avgrateing;
    }

    public void setAvgrateing(double avgrateing) {
        this.avgrateing = avgrateing;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avgrateing=" + avgrateing +
                ", count=" + count +
                '}';
    }
}
