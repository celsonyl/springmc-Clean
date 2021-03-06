package com.nyller.springmcclean.gateway.mysql.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nyller.springmcclean.domain.enums.PaymentStatus;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PaymentWithBankSlipDatabase extends PaymentDatabase implements Serializable {

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm", timezone = "GMT-3")
    private Date expirationDate;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm", timezone = "GMT-3")
    private Date paymentDate;

    public PaymentWithBankSlipDatabase() {
    }

    public PaymentWithBankSlipDatabase(Date expirationDate, Date paymentDate) {
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
    }

    public PaymentWithBankSlipDatabase(Integer id, PaymentStatus paymentStatus, OrderDatabase orderDatabase, Date expirationDate, Date paymentDate) {
        super(id, paymentStatus, orderDatabase);
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}