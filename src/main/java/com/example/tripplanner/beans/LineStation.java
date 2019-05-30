package com.example.tripplanner.beans;

import javax.persistence.*;

@Entity
@Table(name = "line_station")
public class LineStation {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_line")
    int lineID;

    @Column(name = "id_station")
    int stationID;

    @Column(name = "position")
    int position;

    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "id_line")
     * 
     * @Getter @Setter private Line line;
     * 
     * @ManyToOne
     * 
     * @JoinColumn(name = "id_station")
     * 
     * @Getter @Setter private Station station;
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLineID() {
        return lineID;
    }

    public void setLineID(int lineID) {
        this.lineID = lineID;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
