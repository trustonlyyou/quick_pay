package com.payment.quickpay.domain.user.presentation;

import com.payment.quickpay.domain.user.dto.UserRequest;
import com.payment.quickpay.domain.user.dto.UserResponse;
import com.payment.quickpay.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userCreate(@RequestBody UserRequest request) {
        UserResponse response = userService.crateUser(request);

        return ResponseEntity.ok(response);
    }
}
