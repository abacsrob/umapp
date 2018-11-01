package com.restcourse.umapp.entity;

import com.restcourse.umapp.common.IdentifiableComponent;
import com.restcourse.umapp.common.NameableComponent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User implements IdentifiableComponent, NameableComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column( /* nullable = false */)
    private Boolean locked;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany( /* cascade = { CascadeType.REMOVE }, */fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") })
    private Set<Role> roles;

    public User(String name, String password, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
}
