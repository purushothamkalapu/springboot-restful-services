package com.purushotham.springbootrestfulservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "User DTO Model information"
)
public class UserDTO {
    private Long id;
    //User first name should not be null or empty
    @Schema(
            description = "User First name"
    )
    @NotEmpty(message = "User first name should not be mull or Empty")
    private String firstName;
    //User last name should not be null or empty
    @Schema(
            description = "User Last name"
    )
    @NotEmpty(message = "User last name should not be mull or Empty")
    private String lastName;
    //User email should not be null or empty & Email Address should be valid
    @Schema(
            description = "User Email"
    )
    @NotEmpty(message = "User Email should not be mull or Empty")
    @Email(message = "Email address should be valid")
    private String email;
}
