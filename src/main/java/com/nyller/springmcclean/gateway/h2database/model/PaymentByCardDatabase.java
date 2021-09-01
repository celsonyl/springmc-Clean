package com.nyller.springmcclean.gateway.h2database.model;

import com.nyller.springmcclean.domain.enums.PaymentStatus;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class PaymentByCardDatabase extends PaymentDatabase implements Serializable {

    private Integer numberOfInstallments;

    public PaymentByCardDatabase() {
    }

    public PaymentByCardDatabase(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public PaymentByCardDatabase(Integer id, PaymentStatus paymentStatus, OrderDatabase orderDatabase, Integer numberOfInstallments) {
        super(id, paymentStatus, orderDatabase);
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }
}