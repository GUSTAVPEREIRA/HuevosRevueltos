package com.inc.huevosrevueltos.model.login;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Entity
@Table(name = "farm_user")
@Getter
public class FarmUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
}