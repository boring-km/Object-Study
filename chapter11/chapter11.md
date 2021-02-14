# 합성과 유연한 설계

- 코드 재사용을 위해서는 객체 합성이 클래스 상속보다 더 좋은 방법이다.
- 상속은 부모 클래스 안에 구현된 코드 자체를 재사용하지만,<br>
    합성은 포함되는 객체의 퍼블릭 인터페이스를 재사용한다.

### 1. 상속을 합성으로 변경하기
- 자식 클래스에 선언된 상속 관계를 제거하고 부모 클래스의 인스턴스를 자식 클래스의 인스턴스 변수로 선언하면 된다.

```java
public class Properties {   // Hashtable을 상속하지 않고,

    private Hashtable<String, String> properties = new Hashtable<>();

    public String setProperty(String key, String value) {
        return properties.put(key, value);  // Hashtable의 put()을 사용
    }

    public String getProperty(String key) {
        return properties.get(key);     // Hashtable의 get()을 사용
    }
}

public class Stack<E> {     // Vector를 상속하지 않고,

    private Vector<E> elements = new Vector<>();

    public E push(E item) {
        elements.addElement(item);  // Vector의 addElement()를 사용
        return item;
    }
    
    public E pop() {
        if(elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);   // Vector의 remove()를 사용
    }
}

```
- 몽키 패치(Monkey Patch): 현재 실행 중인 환경에만 영향을 미치도록 지역적으로 코드를 수정하거나 확장하는 것<br>
  자바는 바이트코드를 직접 변환하거나 AOP를 이용해 몽키 패치를 구현하고 있다.

### 2. 상속으로 인한 조합의 폭발적인 증가
- 하나의 기능을 추가하거나 수정하기 위해 불필요하게 많은 수의 클래스를 추가하거나 수정해야 한다.
- 단일 상속만 지원하는 언어에서는 상속으로 인해 오히려 중복 코드의 양이 늘어날 수 있다.

### 3. 합성 관계로 변경하기
- 상속 관계는 컴파일타임에 결정되고 고정되기 때문에 코드를 실행하는 도중에는 변경할 수 없다.<br>
    여러 기능을 조합해야 하는 설계에 상속을 이용하면 모든 조합 가능한 경우별로 클래스를 추가해야 한다.
- 합성은 컴파일타임 관계를 런타임 관계로 변경함으로써 이 문제를 해결한다.<br>
    합성을 사용하여 구현이 아닌 퍼블릭 인터페이스에 대해서만 의존할 수 있기 때문에 런타임에 객체의 관계를 변경할 수 있다.
    
### 4. 믹스인
- 객체를 생성할 때 코드 일부를 클래스 안에 섞어 넣어 재사용하는 기법이다.
- 컴파일 시점에 필요한 코드의 조각을 조합하는 재사용 방법이다.
- 합성처럼 유연하면서도 상속처럼 쉽게 코드를 재사용할 수 있다.
- Scala의 trait: 앞으로 상속될 클래스의 메서드에 기능을 조합하여 사용할 수 있다. super 참조도 동적임
> 믹스인
> - 전통적으로 특정한 클래스의 메서드를 재사용하고 기능을 확장하기 위해 사용돼 있다.
> - 추상 서브클래스(abstract subclass)라고도 불린다.
> - 특정한 클래스에 대한 변경 또는 확장을 독립적으로 구현한 후 필요한 시점에 차례대로 추가할 수 있다.(순서 부여 가능)
