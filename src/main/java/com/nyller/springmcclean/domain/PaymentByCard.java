package com.nyller.springmcclean.domain;

import com.nyller.springmcclean.domain.enums.PaymentStatus;
import com.nyller.springmcclean.gateway.h2database.model.OrderDatabase;
import com.nyller.springmcclean.gateway.h2database.model.PaymentDatabase;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class PaymentByCard extends PaymentDatabase implements Serializable {

    private Integer numberOfInstallments;

    public PaymentByCard() {
    }

    public PaymentByCard(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public PaymentByCard(Integer id, PaymentStatus paymentStatus, OrderDatabase orderDatabase, Integer numberOfInstallments) {
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