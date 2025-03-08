package com.payment.quickpay.domain.paymentmethod.entity;

import com.payment.quickpay.domain.paymentmethod.constant.PayMethod;
import com.payment.quickpay.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "PAY_METHOD")
@Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PayMethod payMethod;

    @Column(name = "DETAIL", nullable = false, length = 255)
    private String detail;

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
