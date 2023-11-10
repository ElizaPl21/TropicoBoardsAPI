package com.gen.TropicoBoards.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.TropicoBoards.Model.Payments;
import com.gen.TropicoBoards.Repository.PaymentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    @Autowired
    public PaymentsService(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    public Payments createPayments(Payments payments) {
        return paymentsRepository.save(payments);
    }

    public Payments updatePayments(Payments payments) {
        return paymentsRepository.save(payments);
    }

    public void deletePayments(Long paymentId) {
        paymentsRepository.deleteById(paymentId);
    }

    public Optional<Payments> getPaymentById(Long paymentId) {
        return paymentsRepository.findById(paymentId);
    }

    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }
}