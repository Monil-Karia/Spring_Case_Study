package org.example.controller;

import org.example.model.Loan;
import org.example.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/issue")
    public Loan issueLoan(@RequestParam Long customerId,
                          @RequestParam Long loanTypeId,
                          @RequestParam String issueDate,
                          @RequestParam String endDate) {
        return loanService.issueLoan(customerId, loanTypeId, LocalDate.parse(issueDate), LocalDate.parse(endDate));
    }

    @DeleteMapping("/{loanId}")
    public void deleteLoan(@PathVariable Long loanId) {
        loanService.deleteLoan(loanId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Loan> getLoansByCustomer(@PathVariable Long customerId) {
        return loanService.getLoansByCustomer(customerId);
    }

    @GetMapping("/type/{loanTypeId}")
    public List<Loan> getLoansByLoanType(@PathVariable Long loanTypeId) {
        return loanService.getLoansByLoanType(loanTypeId);
    }

    @GetMapping("/{loanId}")
    public Loan getLoanById(@PathVariable Long loanId) {
        return loanService.getLoanById(loanId);
    }

    @PutMapping("/{loanId}")
    public Loan updateLoan(@PathVariable Long loanId,
                           @RequestParam Long customerId,
                           @RequestParam Long loanTypeId,
                           @RequestParam String issueDate,
                           @RequestParam String endDate) {
        Loan loan = new Loan();
        loan.setCustomer(new Customer());
        loan.setLoanType(new LoanType());
        loan.setIssueDate(LocalDate.parse(issueDate));
        loan.setEndDate(LocalDate.parse(endDate));
        return loanService.updateLoan(loanId, loan);
    }

    @GetMapping("/all")
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }
}
