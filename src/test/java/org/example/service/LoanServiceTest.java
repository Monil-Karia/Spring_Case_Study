package org.example.service;


import org.example.model.Customer;
import org.example.model.Loan;
import org.example.model.LoanType;
import org.example.repository.CustomerRepository;
import org.example.repository.LoanRepository;
import org.example.repository.LoanTypeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private LoanTypeRepository loanTypeRepository;

    @InjectMocks
    private LoanService loanService;

    public LoanServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIssueLoan() {
        Customer customer = new Customer();
        customer.setId(1L);

        LoanType loanType = new LoanType();
        loanType.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(loanTypeRepository.findById(1L)).thenReturn(Optional.of(loanType));

        Loan loan = loanService.issueLoan(1L, 1L, LocalDate.now(), LocalDate.now().plusYears(1));
        assertNotNull(loan);
        verify(loanRepository).save(any(Loan.class));
    }
}
