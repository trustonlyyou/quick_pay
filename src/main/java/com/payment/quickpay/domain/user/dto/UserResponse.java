package com.payment.quickpay.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class UserResponse {
    private String name;
    private String email;
}
