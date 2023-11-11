package com.gt.basketballapp.model;

public enum CourtType {
    INDOOR("INDOOR"),
    OUTDOOR("OUTDOOR"),
    MODULAR_FIBA("MODULAR FIBA"),
    TARTAN("TARTAN");

    public final String label;

    CourtType(String value) {
        this.label = value;
    }
}
