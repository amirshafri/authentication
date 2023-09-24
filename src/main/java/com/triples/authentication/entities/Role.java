package com.triples.authentication.entities;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false, unique = true)
    private String name;
    // Getters and setters

}
