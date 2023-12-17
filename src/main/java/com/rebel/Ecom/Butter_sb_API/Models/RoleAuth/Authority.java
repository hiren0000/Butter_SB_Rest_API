package com.rebel.Ecom.Butter_sb_API.Models.RoleAuth;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority
{
    private String authority;

    @Override
    public String getAuthority()
    {
        return this.authority;
    }
}
