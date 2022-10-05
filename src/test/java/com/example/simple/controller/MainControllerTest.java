package com.example.simple.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.simple.dto.AuthDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenUserAuthIsInvalid_thenReturnsStatus400() throws Exception {

        AuthDto userAuth = getUserAuth(null, null);
        String body = objectMapper.writeValueAsString(userAuth);

        mvc.perform(post("/api")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenUserAuthIsValid_thenReturnsStatus200() throws Exception {

        AuthDto userAuth = getUserAuth("mail@mail.com", "passw0rd");
        String body = objectMapper.writeValueAsString(userAuth);

        mvc.perform(post("/api")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isOk());
    }

    private AuthDto getUserAuth(String email, String password) {
        AuthDto userAuth = new AuthDto();
        userAuth.setEmail(email);
        userAuth.setPassword(password);
        return userAuth;
    }

}
