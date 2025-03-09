package com.payment.quickpay.domain.user.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.quickpay.domain.user.dto.UserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("사용자 등록 요청 테스트 [정상]")
    public void crateUser() throws Exception {
        //given
        UserRequest request = UserRequest.builder()
                .name("junhwan")
                .email("junhwan@gmail.com")
                .build();

        //when then
        mockMvc.perform(post("/api/v1/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("사용자 등록 요청 Validation Check Fail")
    public void createUserValidationTest() throws Exception {
        //given
        UserRequest request = UserRequest.builder()
                .name("")
                .email("")
                .build();

        //when then
        mockMvc.perform(post("/api/v1/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(result -> assertInstanceOf(MethodArgumentNotValidException.class, result.getResolvedException()))
                .andExpect(status().isBadRequest());
    }
}