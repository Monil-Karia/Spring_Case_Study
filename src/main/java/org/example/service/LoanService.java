package org.example.service;


import org.example.model.Customer;
import org.example.model.Loan;
import org.example.model.LoanType;
import org.example.repository.CustomerRepository;
import org.example.repository.LoanRepository;
import org.example.repository.LoanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanTypeRepository loanTypeRepository;

    public Loan issueLoan(Long customerId, Long loanTypeId, LocalDate issueDate, LocalDate endDate) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        Optional<LoanType> loanTypeOpt = loanTypeRepository.findById(loanTypeId);

        if (customerOpt.isPresent() && loanTypeOpt.isPresent()) {
            Loan loan = new Loan();
            loan.setCustomer(customerOpt.get());
            loan.setLoanType(loanTypeOpt.get());
            loan.setIssueDate(issueDate);
            loan.setEndDate(endDate);
            return loanRepository.save(loan);
        }
        return null;
    }

    public void deleteLoan(Long loanId) {
        loanRepository.deleteById(loanId);
    }

    public List<Loan> getLoansByCustomer(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }

    public List<Loan> getLoansByLoanType(Long loanTypeId) {
        return loanRepository.findByLoanTypeId(loanTypeId);
    }

    public Loan getLoanById(Long loanId) {
        return loanRepository.findById(loanId).orElse(null);
    }

    public Loan updateLoan(Long loanId, Loan updatedLoan) {
        if (loanRepository.existsById(loanId)) {
            updatedLoan.setId(loanId);
            return loanRepository.save(updatedLoan);
        }
        return null;
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
