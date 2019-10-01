package at.htl.Duck;

public class FerruginousDuck extends ADuck {
    public FerruginousDuck()
    {
        setquackbehavior(new IQuackInterface() {
            @Override
            public void quack() {
                System.out.println("I am quacking!");
            }
        });
    }
    @Override
    public void display() {
        System.out.println("Can you see me? I am a FerruginousDuck");
    }
}
