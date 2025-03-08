package com.payment.quickpay.domain.paymentmethod.repository;

import com.payment.quickpay.domain.paymentmethod.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

}
