package com.payment.quickpay.domain.paywallet.repository;

import com.payment.quickpay.domain.paywallet.entity.PayWallet;
import com.payment.quickpay.domain.user.entity.User;
import com.payment.quickpay.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@Transactional
class PayWalletRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PayWalletRepository payWalletRepository;

    @Test
    public void cratePayWalletTest() throws Exception {
        //given
        User user = User.builder()
                .name("JungHwan")
                .email("junghwan@gmail.com")
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);


        //when
        //then
        PayWallet payWallet = PayWallet.builder()
                .user(user)
                .build();

        payWalletRepository.save(payWallet);
    }
}