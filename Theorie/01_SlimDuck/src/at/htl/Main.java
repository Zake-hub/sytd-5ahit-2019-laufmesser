package at.htl;

import at.htl.Duck.ADuck;
import at.htl.Duck.FerruginousDuck;
import at.htl.Duck.MallarDuck;

import java.rmi.MarshalException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MallarDuck duck = new MallarDuck();
        duck.display();
        duck.fly();
        FerruginousDuck fduck = new FerruginousDuck();
        fduck.display();
        fduck.quack();
        fduck.fly();
    }
}
