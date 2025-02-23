package com.facundosaracho.mstransactions.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    @Comment("Importe de la transacción")
    private BigDecimal amount;

    @Column(name = "company_id", nullable = false)
    @Comment("Id de empresa que realiza la transacción.")
    private Long companyId;

    @Column(name = "debit_account", length = 30)
    @Comment("Número de cuenta de débito")
    private String debitAccount;

    @Column(name = "credit_account", length = 30)
    @Comment("Número de cuenta de crédito")
    private String creditAccount;

    @Column(name = "transaction_date", nullable = false, updatable = false)
    @Comment("Fecha en la que se hizo la transacción.")
    private LocalDateTime transactionDate;

    @PrePersist
    void prePersist(){
        transactionDate = LocalDateTime.now();
    }
}
