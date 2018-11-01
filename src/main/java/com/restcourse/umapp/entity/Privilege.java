package com.restcourse.umapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restcourse.umapp.common.IdentifiableComponent;
import com.restcourse.umapp.common.NameableComponent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
public class Privilege implements IdentifiableComponent, NameableComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRIV_ID")
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = false, nullable = false)
    private String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "privileges", fetch = FetchType.EAGER)
    private Set<Role> roles;

    public Privilege(String name) {
        this.name = name;
        this.description = name;
    }
}
