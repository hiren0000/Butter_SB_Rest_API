package com.rebel.Ecom.Butter_sb_API.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name="butter_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId;

    @Column(name = "pName")
    private String pName;

    @Column(name = "pDes")
    private String pDes;

    private Float price;

    @Column(name = "pImage")
    private String pImage;

    @Column(name = "available")
    private Boolean available = true;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    private SubCategory subCategory;

}
