package com.payment.quickpay.domain.user.service;

import com.payment.quickpay.domain.paywallet.entity.PayWallet;
import com.payment.quickpay.domain.paywallet.repository.PayWalletRepository;
import com.payment.quickpay.domain.user.dto.UserRequest;
import com.payment.quickpay.domain.user.dto.UserResponse;
import com.payment.quickpay.domain.user.entity.User;
import com.payment.quickpay.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    private final PayWalletRepository payWalletRepository;

    public UserResponse crateUser(UserRequest request) {

        validateUser(request);

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();

        try {
            user = userRepository.save(user);

            PayWallet payWallet = PayWallet.builder()
                    .user(user)
                    .build();

            payWalletRepository.save(payWallet);
        } catch (Exception e) {

        }

        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    private void validateUser(UserRequest request) {
        User user = userRepository.findUserByEmail(request.getEmail());

        if (Objects.nonNull(user)) {
            System.out.println("Exists Member");
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
