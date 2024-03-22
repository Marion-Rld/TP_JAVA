package edu.mrollando.TP.controllers;

import edu.mrollando.TP.dao.UtilisateurDao;
import edu.mrollando.TP.models.Utilisateur;
import edu.mrollando.TP.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    UtilisateurDao utilisateurDao;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/sign-in")
    public void signIn(@RequestBody Utilisateur utilisateur) {

        utilisateur.setMotDePasse(bCryptPasswordEncoder.encode(utilisateur.getMotDePasse()));

        utilisateurDao.save(utilisateur);

    }

    @PostMapping("/login")
    public String login(@RequestBody Utilisateur utilisateur) {

        try {

            UserDetails userDetails = (UserDetails) authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(
                    utilisateur.getPseudo(),
                    utilisateur.getMotDePasse()
            )).getPrincipal();

            return jwtUtils.generateJwt(userDetails);

        } catch (Exception ex) {
            return null;
        }

    }

}
