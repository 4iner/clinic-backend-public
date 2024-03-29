package security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import models.user.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

    
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Integer id, String username, String password, Collection<? extends GrantedAuthority> authorities){
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getName().name()))
            .collect(Collectors.toList());

            return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getPassword(), 
				authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return this.authorities;
    }

    public Integer getId(){
        return this.id;
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        
        return this.username;
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

    @Override
    public boolean isEnabled() {
        
        return true;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        UserDetailsImpl udi = (UserDetailsImpl) o;
        return Objects.equals(id, udi.id);
    }

    
}