package com.rebel.Ecom.Butter_sb_API.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "butter_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer phone;
    private String profile;
    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserRole> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
