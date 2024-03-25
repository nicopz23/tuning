package com.ceica.securityspring.service;

//import com.ceica.securityspring.model.Authority;
import com.ceica.securityspring.model.Usuarios;
//import com.ceica.securityspring.repository.AuthorityRepository;
import com.ceica.securityspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    //private AuthorityRepository authorityRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /*@Autowired
    public UserService(UserRepository userRepository,AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        //his.authorityRepository=authorityRepository;
        passwordEncoder=new BCryptPasswordEncoder();
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios user = userRepository.findByUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con nombre de usuario: " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(
                user.getUser(),
                user.getPassword(),
                authorities
        );
    }

   /* private Collection<? extends GrantedAuthority> getAuthorities(Collection<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return grantedAuthorities;
    }*/

    public void crearUsuario(Usuarios user) {
        //Encriptamos password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       Usuarios newUser=userRepository.save(user);
        //authorityRepository.save(authority);
    }
}
