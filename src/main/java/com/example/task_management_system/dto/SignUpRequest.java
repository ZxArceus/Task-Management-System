package com.example.task_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    @NotBlank
    @Size(max=3, min =20)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no special characters.")
    private  String userName;
    @Email
    private String email;
    @NonNull
    private  String passWord;
}
