package supermario;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public enum BehaviorFactory {
    LEFT(KeyEvent.VK_LEFT, new LeftBehavior()),
    RIGHT(KeyEvent.VK_RIGHT, new RightBehavior()),
    JUMP(KeyEvent.VK_UP, new UpBehavior()),
    CROUCH(KeyEvent.VK_DOWN, new DownBehavior()),

    NOTHING(0, new NoneBehavior()),
    ESCAPE(KeyEvent.VK_ESCAPE, new EscapeBehavior());

    private final int keyCode;
    private final SuperMarioBehavior superMarioBehavior;

    BehaviorFactory(int keyCode, SuperMarioBehavior superMarioBehavior) {
        this.keyCode = keyCode;
        this.superMarioBehavior = superMarioBehavior;
    }

    public static SuperMarioBehavior createBehaviorBy(int keyCode) {
        BehaviorFactory behaviorFactory = getBehaviorFactoryBy(keyCode);
        return behaviorFactory.superMarioBehavior;
    }

    private static BehaviorFactory getBehaviorFactoryBy(int keyCode) {
        return Arrays.stream(BehaviorFactory.values())
                .filter(behavior -> behavior.keyCode == keyCode)
                .findFirst()
                .orElse(NOTHING);
    }
}