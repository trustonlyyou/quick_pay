package com.payment.quickpay.domain.paywallet.repository;

import com.payment.quickpay.domain.paywallet.entity.PayWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayWalletRepository extends JpaRepository<PayWallet, Long> {

}
