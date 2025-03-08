package com.payment.quickpay.domain.paymentmethod.repository;

import com.payment.quickpay.domain.paymentmethod.constant.PayMethod;
import com.payment.quickpay.domain.paymentmethod.entity.PaymentMethod;
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
class PaymentMethodRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;


    @Test
    public void createPaymentTest() throws Exception {
        //given
        User user = User.builder()
                .name("JungHwan")
                .email("junghwan@gmail.com")
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);

        System.out.println(userRepository.findById(user.getId()).get().getName());

        //when
        //then
        PaymentMethod paymentMethod = PaymentMethod.builder()
                .user(user)
                .payMethod(PayMethod.CARD)
                .detail("110409877530")
                .build();

        paymentMethodRepository.save(paymentMethod);

        System.out.println(paymentMethodRepository.findById(paymentMethod.getId()).get().getUser().getName());
    }

}