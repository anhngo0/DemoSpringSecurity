package com.example.demo.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService  implements ApplicationUserDAO {
    private final PasswordEncoder passwordEncoder;
    private final UserConfig userConfig;
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder, UserConfig userConfig) {
        this.passwordEncoder = passwordEncoder;
        this.userConfig = userConfig;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByName(String username) {
        return userConfig.
                getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

   /* private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = List.of(
                new ApplicationUser(
                        STUDENT.getGrantedAuthority(),
                        passwordEncoder.encode("password1"),
                        "johanLiebert",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN.getGrantedAuthority(),
                        passwordEncoder.encode("password2"),
                        "annaLiebert",
                        true,
                        true,
                        true,
                        true
                )
        );
        return applicationUsers;
    }*/
}
