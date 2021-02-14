# 10. 상속과 코드 재사용

### DRY 원칙
- Don't Repeat Yourself
- 코드의 중복을 제거하자 (그래야 수정할 코드가 줄어든다)

## 상속의 문제점들...
- 부모 클래스의 변경에 의해 자식 클래스가 영향을 받는 현상
- 상속을 사용한다면 피할 수 없는 객체지향 프로그래밍의 근본적인 취약성임

### 1. super 호출을 피하자
- 부모 클래스의 구현 방법에 대한 정확한 지식을 가져야 한다. (결합도가 높아짐, 캡슐화를 위반하는 개념)
- 그로 인해 부모 클래스의 변경이 자식 클래스에 영향을 줄 수 있다. [4번과 비슷함]

```java
public class DeliveryPackage {
    protected final long weight;
    protected static final long BASIC_FEE = 2500;

    public long calculateWeightFee() {
        return BASIC_FEE + (weight / 10) * 1000;
    }
}

public class HeavyDeliveryPackage extends DeliveryPackage {
    @Override
    protected long calculateWeightFee() {
        return BASIC_FEE + (weight / 10) * 2000;
    }
}
```
- 새로운 로직이 추가되면 자식 클래스에도 영향을 준다.
```java
public class DeliveryPackage {
    protected final double discountPercent;
    public long calculateWeightFee() {
        return (long) ((double)(BASIC_FEE + (weight / 10) * 1000) * (1 - discountPercent));
    }
}

public class HeavyDeliveryPackage extends DeliveryPackage {
    @Override
    public long calculateWeightFee() {
        return (long) ((double)(BASIC_FEE + (weight / 10) * 2000) * (1 - super.discountPercent));
    }
}
```
    
### 2. 부모 클래스의 불필요한 인터페이스를 사용할 수도 있는지 주의하자
- 부모 클래스의 메서드가 자식 클래스의 내부 구조에 대한 규칙을 깨트릴 수 있다.
- 부모 클래스에서는 사용해도 되는 넓은 개념이지만, 자식 클래스에서는 금지해야하는 개념일수도 있다. (LSP 위반)
```java
    @Test
    public void 스택_클래스에_push가_아닌_add를_사용하여_0번째_인덱스에_4를_넣으면_스택에서_꺼낸_값은_4가_아니다() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.add(0, 4);    // 스택의 규칙에 위반되는 행동이지만 Vector 클래스의 메서드로서 동작한다.
        assertNotEquals(Integer.valueOf(4), stack.pop());
    }
    @Test
    public void 반지름이_4인_구의_겉넓이는_반올림해서_201이다() {
        Circle ball = new Ball(4);
        assertEquals(201, Math.round(ball.calculateSurfaceArea()));
        assertNotEquals(201, Math.round(ball.calculateArea())); // 구에서 평면의 원에서 사용하는 넓이 공식을 사용하면 안된다.
    }
```
    
### 3. 메서드 오버라이딩의 오작용에 주의하자
- 자식 클래스가 부모 클래스의 메서드를 오버라이딩할 경우 부모 클래스가 자신의 메서드를 사용하는 방법에 자식 클래스가 결합될 수 있다.
- 교재의 InstrumentedHashSet 예시 (추가 예시 아직 없음...)

```java
public class InstrumentedHashSet<E> extends HashSet<E>  {
    private int addCount = 0;

    public int getAddCount() {
        return addCount;
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
}

// AbstractCollection.java
public abstract class AbstractCollection<E> implements Collection<E> {
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }
}
```

### 4. 부모 클래스의 변경이 자식 클래스의 변경을 요구할 수 있다.
- 자식 클래스는 부모 클래스의 세부적인 구현에 의존한다.
- 부모 클래스가 확장될 목적으로 설계된 클래스가 아니라면 자식 클래스는 부모 클래스에 보조를 맞춰서 함께 변경되어야 한다.
- 교제의 Playlist 예시
```java
public class Playlist {
    private List<Song> tracks = new ArrayList<>();
    private Map<String, String> singers = new HashMap<>();  // 추가된 singers 맵

    public void append(Song song) {
        getTracks().add(song);
        singers.put(song.getSinger(), song.getTitle());
    }
    public List<Song> getTracks() {
        return tracks;
    }

    public Map<String, String> getSingers() {
        return singers;
    }
}

public class PersonalPlaylist extends Playlist {
    public void remove(Song song) {
        getTracks().remove(song);
        getSingers().remove(song.getSinger());  // 부모 클래스의 설계가 바뀌면서 자식 클래스에도 영향을 줄 수 있다.
    }
}
```

#### 리스코프 치환 원칙 (LSP)
- 자료형 S가 자료형 T의 하위형이라면 필요한 프로그램의 속성의 변경 없이 자료형 T의 객체를 자료형 S의 객체로 교체할 수 있어야 한다.
- Animal 클래스 예시
```java
public class Animal {   // LSP 위반?

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat(Food food) {
        System.out.println(name + "가 " +food.getName() + "를 먹다.");
    }
}

class Puppy extends Animal {    // 강아지는 야채와 고기를 둘 다 먹을 수 있다.

    Puppy(String name) {
        super(name);
    }
}

class Lion extends Animal {    // 사자는 고기만 먹는다.

    Lion(String name) {
        super(name);
    }
}

class Elephant extends Animal {     // 코끼리는 고기를 먹지 않는다.

    public Elephant(String name) {
        super(name);
    }
}
```

## 추상화에 의존하자
- 중복되는 코드만 부모 클래스에 올리고, 각자 따로 구현해야할 코드는 추상화 메서드로 선언하자
- 추상화를 통해 SRP, OCP, DIP를 지킬 수 있게 된다... (ISP랑 LSP는 아님)

## 차이에 의한 프로그래밍
- 목표: 중복 코드를 제거하고 코드를 재사용하는 것
- 기존 코드와 다른 부분만을 추가함으로써 애플리케이션의 기능을 확장하는 방법을 **차이에 의한 프로그래밍**이라고 한다.
- 상속의 단점을 피하면서 코드를 재사용하는 합성은 다음 챕터에서...
