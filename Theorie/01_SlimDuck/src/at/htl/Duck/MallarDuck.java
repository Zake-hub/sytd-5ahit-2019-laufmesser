package at.htl.Duck;

public class MallarDuck extends ADuck {
    public MallarDuck()
    {
        setflybehavior(new IFlyInterface() {
            @Override
            public void fly() {
                System.out.println("I am flying!");
            }
        });
    }
    @Override
    public void display() {
        System.out.println("Can you see me? i am a Mallarduck!");
    }
}
