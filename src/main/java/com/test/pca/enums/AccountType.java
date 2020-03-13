package com.test.pca.enums;

public enum AccountType {
    COURANT("compte courant"),
    SURCARNET("compte sur carnet"),
    INTERNECREDIT("compte interne credit"),
    MADUMONDE("compte marocains du monde"),
    PRO("compte pro"),
    PERSONNELBANQUE("compte personnel de la banque");
    private String description;

    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
