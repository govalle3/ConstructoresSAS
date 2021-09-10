package com.ceiba.ConstructoresSAS.infraestructure.adapters.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name= "construction")
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionEntity implements Serializable {

    private static final long serialVersionUID = -5265019002696147998L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "constructionType" ,nullable = false, length = 255)
    private String constructionType;

    @Column(name = "requestDay", nullable = false, length = 255)
    private LocalDate requestDay;

    @Column(name = "startConstructionDay", nullable = false, length = 255)
    private LocalDate startConstructionDay;

    @Column(name = "finishConstructionDay", nullable = false, length = 255)
    private LocalDate finishConstructionDay;

    @Column(name = "coordinateX", nullable = false, length = 255)
    private String coordinateX;

    @Column(name = "coordinateY", nullable = false, length = 255)
    private String coordinateY;

    @Column(name = "state", nullable = false, length = 255)
    private String state;

}
