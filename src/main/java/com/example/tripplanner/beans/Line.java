package com.example.tripplanner.beans;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Line
 */
@Entity
@Table(name = "line")
public class Line {

    @Id
    @Column(name = "id")
    @Getter
    @Setter
    private int id;

    @Column(name = "line_number")
    @Getter
    @Setter
    private String lineNumber;

    @Column(name = "line_type")
    @Getter
    @Setter
    private int lineType;
/*
    @OneToMany(mappedBy = "line", cascade = CascadeType.ALL)
    private List<LineStation> lineStation;
*/
}