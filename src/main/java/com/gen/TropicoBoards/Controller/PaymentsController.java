package com.gen.TropicoBoards.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gen.TropicoBoards.Model.Payments;
import com.gen.TropicoBoards.Service.PaymentsService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/payments")
public class PaymentsController {

    private final PaymentsService paymentsService;

    @Autowired
    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @GetMapping
    public ResponseEntity<List<Payments>> getAllPayments() {
        List<Payments> payments = paymentsService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable Long paymentId) {
        Optional<Payments> payments = paymentsService.getPaymentById(paymentId);
        if (payments.isPresent()) {
            return new ResponseEntity<>(payments.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Payments> createPayments(@RequestBody Payments payments) {
        Payments createdPayments = paymentsService.createPayments(payments);
        return new ResponseEntity<>(createdPayments, HttpStatus.CREATED);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payments> updatePayments(@PathVariable Long paymentId, @RequestBody Payments payments) {
        Optional<Payments> existingPayments = paymentsService.getPaymentById(paymentId);
        if (existingPayments.isPresent()) {
            payments.setId_payments(paymentId);
            Payments updatedPayments = paymentsService.updatePayments(payments);
            return new ResponseEntity<>(updatedPayments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayments(@PathVariable Long paymentId) {
    	paymentsService.deletePayments(paymentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}