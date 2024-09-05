package org.example.controller;

import org.example.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoanController.class)
public class LoanControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loanController).build();
    }

    @Test
    public void testIssueLoan() throws Exception {
        mockMvc.perform(post("/loans/issue")
                        .param("customerId", "1")
                        .param("loanTypeId", "1")
                        .param("issueDate", "2024-01-01")
                        .param("endDate", "2025-01-01"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllLoans() throws Exception {
        mockMvc.perform(get("/loans/all"))
                .andExpect(status().isOk());
    }
}
