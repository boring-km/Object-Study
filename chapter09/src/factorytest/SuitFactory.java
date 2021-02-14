package factorytest;

import java.util.function.Supplier;

public enum SuitFactory {
    Space(SpaceSuit::new),
    Hydro(HydroSuit::new),
    Stealth(StealthSuit::new),
    Combat(CombatSuit::new);

    public final Supplier<Suit> factory;

    SuitFactory(Supplier<Suit> factory) {
        this.factory = factory;
    }
}