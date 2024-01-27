package com.rebel.Ecom.Butter_sb_API.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.Set;

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

    private Float actualPrice;

    private Float discountPrice;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "product_images",
            joinColumns = {
             @JoinColumn(name = "p_id")
            },

            inverseJoinColumns = {
                    @JoinColumn(name = "id")
            }
    )
    private Set<ImageModel> productImages;

    @Column(name = "available")
    private Boolean available = true;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    private SubCategory subCategory;

}
