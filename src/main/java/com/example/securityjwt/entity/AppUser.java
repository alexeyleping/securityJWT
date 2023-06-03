
package com.example.securityjwt.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "appuser")
@Data
@RequiredArgsConstructor
public class AppUser {

    @Id
    @Column(name = "id")
    UUID id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "appuser_approles",
            joinColumns = @JoinColumn(name = "appuser_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "approles_id", referencedColumnName = "id")
    )
    private Set<AppRole> appRoles;

}

