package at.htl.Duck;

public abstract class ADuck {
    private IQuackInterface quackInterface;
    private IFlyInterface flyInterface;

    public abstract void display();

    public void fly()
    {
        flyInterface.fly();
    }
    public void quack()
    {
        quackInterface.quack();
    }
    public void swim()
    {
        System.out.println("I am swimming!");
    }
    public void setquackbehavior(IQuackInterface iQuackInterface)
    {
        this.quackInterface = iQuackInterface;
    }
    public void setflybehavior(IFlyInterface iFlyInterface)
    {
        this.flyInterface = iFlyInterface;
    }
}
