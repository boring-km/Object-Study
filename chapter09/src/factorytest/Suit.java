package factorytest;

public abstract class Suit {
    public abstract String getName();
}

class SpaceSuit extends Suit {

    @Override
    public String getName() {
        return "스페이스 수트!";
    }
}

class HydroSuit extends Suit {

    @Override
    public String getName() {
        return "하이드로 수트!";
    }
}

class StealthSuit extends Suit {

    @Override
    public String getName() {
        return "스텔스 수트!";
    }
}

class CombatSuit extends Suit {
    @Override
    public String getName() {
        return "전투 수트!";
    }
}


