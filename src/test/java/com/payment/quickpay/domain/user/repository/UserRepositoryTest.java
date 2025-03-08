package com.payment.quickpay.domain.user.repository;


import com.payment.quickpay.domain.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void createUserTest() throws Exception {
        //given
        User user = User.builder()
                .name("JungHwan")
                .email("junghwan@gmail.com")
                .createdAt(LocalDateTime.now())
                .build();

        System.out.println(user);

        //when
        //then
        User createUser = userRepository.save(user);
        assertNotNull(createUser);
        assertEquals(user.getId(), createUser.getId());
        assertEquals(user.getName(), createUser.getName());
        assertEquals(user.getEmail(), createUser.getEmail());
        assertEquals(user.getCreatedAt(), createUser.getCreatedAt());

    }
}