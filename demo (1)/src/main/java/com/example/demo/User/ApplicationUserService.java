package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {
    private final ApplicationUserDAO applicationUserDAO;

    @Autowired
    public ApplicationUserService(@Qualifier("fake") ApplicationUserDAO applicationUserDAO) {
        this.applicationUserDAO = applicationUserDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDAO.selectApplicationUserByName(username)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("Username %s is not founr", username)));
    }
}
