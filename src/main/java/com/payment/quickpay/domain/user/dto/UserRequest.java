package com.payment.quickpay.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "User name is not Blank")
    private String name;
    @NotBlank(message = "User email is not Blank")
    private String email;
}
