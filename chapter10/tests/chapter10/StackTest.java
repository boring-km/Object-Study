package chapter10;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertNotEquals;

public class StackTest {
    @Test
    public void 스택_클래스에_push가_아닌_add를_사용하여_0번째_인덱스에_4를_넣으면_스택에서_꺼낸_값은_4가_아니다() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.add(0, 4);
        assertNotEquals(Integer.valueOf(4), stack.pop());
    }
}
