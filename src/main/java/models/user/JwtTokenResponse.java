package models.user;

import java.util.List;

public class JwtTokenResponse {
    private String username;
    private String jwtToken;
    private Integer id;
    private List<String> roles;

    public JwtTokenResponse( Integer id, String username, List<String> roles, String token){
        this.username = username;
        this.id = id;
        this.jwtToken = token;
        this.roles = roles;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


    
}