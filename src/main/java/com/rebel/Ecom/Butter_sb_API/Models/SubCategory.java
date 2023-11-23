package com.rebel.Ecom.Butter_sb_API.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="butter_subcategory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubCategory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scatId;
    private String scatName;
    private String scatDes;

    @ManyToOne
    @JsonIgnore
     private Category category;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Product> products = new ArrayList<>();
}
