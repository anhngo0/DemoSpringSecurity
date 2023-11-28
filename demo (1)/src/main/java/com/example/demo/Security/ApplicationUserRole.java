package com.example.demo.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.example.demo.Security.ApplicationUserPermissions.*;

public enum ApplicationUserRole {
    STUDENT(new HashSet<>(Arrays.asList())),
    ADMIN(new HashSet<>(Arrays.asList(COURSE_WRITE,COURSE_READ,STUDENT_READ,STUDENT_WRITE))),
    ADMIN_TRAINEE(new HashSet<>(Arrays.asList(COURSE_READ,STUDENT_READ)));
    private final Set<ApplicationUserPermissions> permissions;

    public Set<ApplicationUserPermissions> getPermissions() {
        return permissions;
    }

    ApplicationUserRole(Set<ApplicationUserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
