package com.payment.quickpay.domain.paywallet.entity;

import com.payment.quickpay.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAY_WALLET")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "CREATE_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATE_AT")
    private LocalDateTime updateAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }
}
