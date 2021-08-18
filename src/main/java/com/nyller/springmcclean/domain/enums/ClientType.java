package com.nyller.springmcclean.domain.enums;

public enum ClientType {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private Integer cod;
    private String desc;

    ClientType() {
    }

    ClientType(Integer cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static ClientType toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null) {
            return null;
        }

        for (ClientType x : ClientType.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalAccessException("Id invalido" + cod);
    }
}