package com.mikelaskowski.MOMP.restControllers;

import com.mikelaskowski.MOMP.entity.Payment;
import com.mikelaskowski.MOMP.entity.User;
import com.mikelaskowski.MOMP.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payments")
    public List<Payment> findPayments() {
        return paymentService.findPayments();
    }

    @GetMapping(value = "/payments/{paymentId}")
    public Payment getPayment(@PathVariable int paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping(value = "/payments")
    public Payment savePayment(@RequestBody Payment payment) {

        // assign 0 to payment's id because we use method saveOrUpdate() in PaymentDaoImpl
        // when we assign 0, we inform Hibernate that we create new object
        payment.setId(0);

        paymentService.save(payment);

        return payment;
    }

    @PutMapping(value = "/payments")
    public Payment updatePayment(@RequestBody Payment payment) {
        paymentService.updatePayment(payment);

        return payment;
    }

    @DeleteMapping(value = "/payments/{paymentId}")
    public void deletePayment(@PathVariable int paymentId) {
        paymentService.deletePayment(paymentId);
    }

}
