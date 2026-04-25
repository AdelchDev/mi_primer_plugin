package me.adelch.Items.Weapons;

import net.kyori.adventure.text.format.NamedTextColor;

public enum WeaponTierTypes {
    COMMON(NamedTextColor.GRAY, "Común"),
    UNCOMMON(NamedTextColor.GREEN, "Poco Común"),
    RARE(NamedTextColor.BLUE, "Raro"),
    EPIC(NamedTextColor.DARK_PURPLE, "Épico"),
    LEGENDARY(NamedTextColor.GOLD, "Legendario");

    private final NamedTextColor color;
    private final String displayName;

    WeaponTierTypes(NamedTextColor color, String displayName) {
        this.color = color;
        this.displayName = displayName;
    }

    public NamedTextColor getColor() {
        return color;
    }

    public String getDisplayName() {
        return displayName;
    }
}
