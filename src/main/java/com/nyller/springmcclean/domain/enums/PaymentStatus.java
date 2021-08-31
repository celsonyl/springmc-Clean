package com.nyller.springmcclean.domain.enums;

public enum PaymentStatus {

    PENDENT(1, "Pendente"),
    QUITED(2, "Quitado"),
    CANCELED(3, "Cancelado");

    private final Integer cod;
    private final String desc;

    PaymentStatus(Integer cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public static PaymentStatus toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null) {
            return null;
        }

        for (PaymentStatus x : PaymentStatus.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalAccessException("Id invalido" + cod);
    }

    public Integer getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }
}