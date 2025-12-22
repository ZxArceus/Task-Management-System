package com.example.task_management_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;


import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private  String accessToken;
    private String refreshToken;
    private String tokenType="Bearer";
    @NotNull
    private ObjectId userId;
    @NotBlank
    @Size(max=3, min =20)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no special characters.")
    private  String userName;

    Set<String> roles;

}
