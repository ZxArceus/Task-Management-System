package com.example.task_management_system.dto;

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
public class LogInRequest {

    @NotBlank
    @Size(max=3, min =20)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no special characters.")
    private  String userName;
    @NonNull
    private  String passWord;
}
