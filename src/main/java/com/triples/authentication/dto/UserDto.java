package com.triples.authentication.dto;

import com.triples.authentication.entities.Role;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Set<Role> roles; // Assuming Role has a field for role names
    private String password;
}
