package com.codemsaters.Accomodate.Me.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface StudentDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
