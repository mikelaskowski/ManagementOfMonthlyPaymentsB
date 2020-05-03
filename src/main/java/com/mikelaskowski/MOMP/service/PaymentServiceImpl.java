package com.mikelaskowski.MOMP.service;

import com.mikelaskowski.MOMP.dao.PaymentDao;
import com.mikelaskowski.MOMP.entity.Payment;
import com.mikelaskowski.MOMP.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Transactional
    @Override
    public List<Payment> findPayments() {
        return null;
    }

    @Transactional
    @Override
    public Payment getPaymentById(int paymentId) {
        return null;
    }

    @Transactional
    @Override
    public Payment save(Payment payment) {
        return null;
    }

    @Transactional
    @Override
    public void updatePayment(Payment payment) {

    }

    @Transactional
    @Override
    public void deletePayment(int paymentId) {

    }
}
