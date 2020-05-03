package com.mikelaskowski.MOMP.dao;

import com.mikelaskowski.MOMP.entity.Payment;
import com.mikelaskowski.MOMP.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDaoImpl implements PaymentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Payment> findPayments() {
        return null;
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        return null;
    }

    @Override
    public Payment save(Payment payment) {
        return null;
    }

    @Override
    public void updatePayment(Payment payment) {

    }

    @Override
    public void deletePayment(int paymentId) {

    }
}
