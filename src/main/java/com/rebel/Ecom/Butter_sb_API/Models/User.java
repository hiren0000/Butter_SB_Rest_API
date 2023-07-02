package com.rebel.Ecom.Butter_sb_API.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "butter_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer phone;
    private String profile;
    private boolean enabled =false;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserRole> roles = new ArrayList<>();



}
