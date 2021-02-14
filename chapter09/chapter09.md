
## 1. 개방-폐쇄 원칙 (Open-Closed Principle)
- 개방: 소프트웨어 개체는 확장에 열려 있어야 한다.
- 폐쇄: 수정에 대해서는 닫혀 있어야 한다.

```java
// keyEventCode 값에 따라 런타임 의존성이 변경된다, 확장에 열려 있다.
// SuperMarioBehavior는 BehaviorFactory에서 생성한 객체에 따른 변경이 일어나지 않는다.
public class SuperMario {
    private void moveSuperMario(int keyEventCode) {
        SuperMarioBehavior behavior = BehaviorFactory.findBehavior(keyEventCode);
        behavior.action();
    }
}

public interface SuperMarioBehavior {
    void action();
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
```

## 2. Factory (생성 사용 분리)
- 객체 생성에 특화된 객체! (객체 생성의 책임만 전담한다!) 
- 객체의 생성과 사용을 분리 
- 행위적 분해 
- PURE FABRICATION

## 3. 의존성 주입 
- 외부에서 의존성의 대상을 해결한 후 이를 사용하는 객체 쪽으로 주입하기 때문이다. 
- 생성자 주입: 객체 생성 시점에 생성자를 통해 의존성 해결
- setter 주입: 객체 생성 후에 setter 메서드를 통해 의존성 해결
- 메서드 주입: 메서드가 의존성을 필요로 하는 유일한 경우일 때 사용 -?

- 역할, 책임, 협력

#### 인터넷에서 검색한 의존성 주입의 장점 
    - 부가적인 장점들일 뿐임
    2. 테스트에 용이하다. (?)
    3. 코드를 단순화 시킨다. - 객체 생성에 대한 코드가 줄어든다?


#### setter 주입
- 장점은 의존성의 대상을 런타임에 변경할 수 있다.
- 단점은 객체가 올바로 생성되기 위해 어떤 의존성이 필수적인지를 명시적으로 표현할 수 없다.


## 4. 숨겨진 의존성
- SERVICE LOCATOR 패턴 
- 문제점: 의존성을 이해하기 위해 코드의 내부 구현을 이해할 것을 강요한다!
```java
public class SugarServiceLocator {
    private static SugarServiceLocator sugarServiceLocator = new SugarServiceLocator();
    private Sugar sugar;

    public static Sugar sugar() {
        return sugarServiceLocator.sugar;
    }

    public static void setSugar(Sugar sugar) {
        sugarServiceLocator.sugar = sugar;
    }

    private SugarServiceLocator() {
        // 생성자를 못 만들게 하려고?
    }
}

public class CoffeeShopTest {
    @Test
    public void 고객이_설탕_2스푼을_정하고_바리스타에게_아메리카노를_주문하면_아메리카노_맛에_설탕_2스푼_들어간_커피다() {
        
        Customer customer = new Customer();
        SugarServiceLocator.setSugar(new Sugar(2));
        Coffee coffee = customer.order(new Barista(), "아메리카노");
        assertEquals("아메리카노 맛에 설탕 2스푼 들어간 커피", coffee.taste());
    }
}
```
- 단점
    1. 문제점 발견 시점이 코드 작성 시점이 아니라 실행 시점으로 미루어져 이해하기 어렵고 디버깅하기 어렵다.
    2. 단위 테스트 작성이 어렵다 - 모든 단위 테스트 케이스에 걸쳐 ServiceLocator의 상태를 공유하게 된다.
- 어쩔 수 없이 사용하는 경우
    1. 의존성 주입을 지원하는 프레임워크를 사용하지 못하는 경우
    2. 깊은 호출 계층에 걸쳐 동일한 객체를 계속해서 전달해야 하는 고통을 견디기 어려운 경우


## 5. 의존성 역전 원칙 (Dependency Inversion Principle) 
- 유연하고 재사용 가능하며 컨텍스트에 독립적인 설계는 전통적인 패러다임이 고수하는 의존성의 방향을 역전시킨다.
- 객체지향 패러다임은 상위 인터페이스가 상위 수준의 모듈에 속한다.

1. 상위 수준의 모듈과 하위 수준의 모듈은 모두 **추상화**에 의존해야 한다.  
2. 추상화는 구체적인 사항에 의존해서는 안 된다. 구체적인 사항은 추상화에 의존해야 한다.
3. 재사용될 필요가 없는 클래스들은 별도의 독립적인 패키지에 모아야 한다 - SEPARATED INTERFACE 패턴

## 6. 유연한 설계는 유연성이 필요할 때만 옳다