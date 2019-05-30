package com.example.tripplanner.beans;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "station")
@EqualsAndHashCode(of = "id")
public class Station {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "label_fr")
    private String label;

    @Column(name = "longitude")
    private float longitude;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "station_type")
    private int type;

    /*
    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LineStation> lineStation;
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"label\":\"" + label + '\"' +
                ", \"longitude\":" + longitude +
                ", \"latitude\":" + latitude +
                ", \"type\":" + type +
                '}';
    }
}
