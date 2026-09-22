package com.smart.contact.manger.config;

import com.smart.contact.manger.Entity.user;
import com.smart.contact.manger.Reposetery.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDeatilServiceImpl implements UserDetailsService {
@Autowired
    private userrepo Userrepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    user User= Userrepo.findByEmail(username);
    if (User==null){
        throw new UsernameNotFoundException("could not found user namee");
    }
    CustomUserDetails customUserDetails=new CustomUserDetails(User);
        return customUserDetails;
    }
}
