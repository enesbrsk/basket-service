package com.service.englishdise.enums;

public enum MatchStatus {
    PENDING("Beklemede"),
    ACCEPTED("Kabul Edildi"),
    DECLINED("Reddedildi"),
    CANCELED("İptal Edildi");

    private final String displayName;

    MatchStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}