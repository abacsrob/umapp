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
public class Role implements IdentifiableComponent, NameableComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PRIV_ID", referencedColumnName = "PRIV_ID") })
    private Set<Privilege> privileges;

    public Role(String name, Set<Privilege> privileges) {
        this.name = name;
        this.privileges = privileges;
    }
}
