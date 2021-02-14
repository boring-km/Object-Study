package supermario;

public interface SuperMarioBehavior {
    void action();
}

class NoneBehavior implements SuperMarioBehavior {
    @Override
    public void action() {

    }
}

class UpBehavior implements SuperMarioBehavior {
    @Override
    public void action() {
        Thread jumpThread = new Thread(() -> {
            System.out.println("점프!");
            try {
                Thread.sleep(1000);
                System.out.println("떨어집니다!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        jumpThread.start();
    }
}

class DownBehavior implements SuperMarioBehavior {
    @Override
    public void action() {
        System.out.println("웅크리는 중...");
    }
}

class LeftBehavior implements SuperMarioBehavior {
    @Override
    public void action() {
        System.out.println("뒤로 가는중...");
    }
}

class RightBehavior implements SuperMarioBehavior {
    @Override
    public void action() {
        System.out.println("앞으로 가는중...");
    }
}

class EscapeBehavior implements SuperMarioBehavior {
    @Override
    public void action() {
        System.exit(0);
    }
}
