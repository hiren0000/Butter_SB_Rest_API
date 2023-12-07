package com.rebel.Ecom.Butter_sb_API.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRole
{
    @Id
    private Integer rId;
    private String rName;


}
