package com.mikelaskowski.MOMP.dao;

import com.mikelaskowski.MOMP.entity.Payment;
import com.mikelaskowski.MOMP.entity.User;

import java.util.List;

public interface PaymentDao {

    List<Payment> findPayments();

    Payment getPaymentById(int paymentId);

    Payment save (Payment payment);

    void updatePayment(Payment payment);

    void deletePayment(int paymentId);
}
