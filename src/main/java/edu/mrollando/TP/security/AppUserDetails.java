package edu.mrollando.TP.security;

import edu.mrollando.TP.models.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDetails implements UserDetails {

    private Utilisateur utilisateur;

    public AppUserDetails(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (utilisateur.isAdmin()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        if (utilisateur.getRole() != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + utilisateur.getRole().getDesignation().toUpperCase()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return utilisateur.getMotDePasse();
    }

    @Override
    public String getUsername() {
        return utilisateur.getPseudo();
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
}
