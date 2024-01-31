package com.rebel.Ecom.Butter_sb_API.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "image_table")
@NoArgsConstructor

@Getter
@Setter
public class ImageModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String imageName;
    private String imageType;

    @Column(length = 5000000)
    private byte [] imgByte;

    public ImageModel(String imageName, String imageType, byte[] imgByte) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.imgByte = imgByte;
    }
}
