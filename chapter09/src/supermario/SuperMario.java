package supermario;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SuperMario extends JFrame implements Runnable, KeyListener {

    public SuperMario() {
        addKeyListener(this);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 문자 입력을 인식하는 메서드
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyEventCode = e.getKeyCode();
        moveSuperMario(keyEventCode);
    }

    private void moveSuperMario(int keyEventCode) {
        SuperMarioBehavior behavior = BehaviorFactory.createBehaviorBy(keyEventCode);
        behavior.action();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 모든 키보드 자판의 키가 눌린 상태에서 떼어졌을 때 인식하는 메서드
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while(true) {   // moveSuperMario()에서 ESC 키로 강제로 프로그램 종료 가능함.
            try {
                //noinspection BusyWait
                Thread.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}