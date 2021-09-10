package com.ceiba.ConstructoresSAS.infraestructure.adapters.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name= "materials")
@NoArgsConstructor
@AllArgsConstructor
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "concrete" ,nullable = false, length = 255)
    private Integer concrete;

    @Column(name = "gravel", nullable = false, length = 255)
    private Integer gravel;

    @Column(name = "sand", nullable = false, length = 255)
    private Integer sand;

    @Column(name = "wood", nullable = false, length = 255)
    private Integer wood;

   @Column(name = "adobe", nullable = false, length = 255)
    private Integer adobe;

}
