package com.example.project.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="role")
public class Roles extends BaseEntity{
    /*private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> userSet;*/
}
