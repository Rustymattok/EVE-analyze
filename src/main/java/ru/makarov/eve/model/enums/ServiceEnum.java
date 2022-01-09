package ru.makarov.eve.model.enums;

import lombok.Getter;

public enum ServiceEnum {
    BOUNTY_MISSIONS("bounty-missions"),
    ASSASINATION_MISSIONS("assasination-missions"),
    COURIER_MISSIONS("courier-missions"),
    INTERBUS("interbus"),
    REPROCESSING_PLANT("reprocessing-plant"),
    REFINERY("refinery"),
    MARKET("market"),
    BLACK_MARKET("black-market"),
    STOCK_EXCHANGE("stock-exchange"),
    CLONING("cloning"),
    SURGERY("surgery"),
    DNA_THERAPY("dna-therapy"),
    REPAIR_FACILITIES("repair-facilities"),
    FACTORY("factory"),
    LABRATORY("labratory"),
    GAMBLING("gambling"),
    FITTING("fitting"),
    PAINTSHOP("paintshop"),
    NEWS("news"),
    STORAGE("storage"),
    INSURES("insurance"),
    DOCKING("docking"),
    OFFICE_RENTAL("office-rental"),
    JUMP_CLONE_FACILITY("jump-clone-facility"),
    LOYALTY_POINT_STORE("loyalty-point-store"),
    NAVY_OFFICES("navy-offices"),
    SECURITY_OFFICES("security-offices");

    ServiceEnum(String title) {
        this.title = title;
    }

    @Getter
    private final String title;

}
