package me.adelch.Items.Trinkets;

import net.kyori.adventure.text.format.NamedTextColor;

public enum TrinketTierType {
    COMMON(0.05, NamedTextColor.GRAY, "Común"),
    UNCOMMON(0.10, NamedTextColor.GREEN, "Poco Común"),
    RARE(0.20, NamedTextColor.BLUE, "Raro"),
    EPIC(0.40, NamedTextColor.DARK_PURPLE, "Épico"),
    LEGENDARY(0.80, NamedTextColor.GOLD, "Legendario");

    private final double boostPercentage;
    private final NamedTextColor color;
    private final String displayName;

    TrinketTierType(double boostPercentage, NamedTextColor color, String displayName) {
        this.boostPercentage = boostPercentage;
        this.color = color;
        this.displayName = displayName;
    }

    public double getBoost() {
        return boostPercentage;
    }

    public NamedTextColor getColor() {
        return color;
    }

    public String getDisplayName() {
        return displayName;
    }
}
