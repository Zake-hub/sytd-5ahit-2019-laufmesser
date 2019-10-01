package at.htl;

import at.htl.builder.QuackBuilder;
import at.htl.ducks.*;
import at.htl.factories.GooseFactory;
import at.htl.factories.MullardDuckFactory;
import at.htl.factories.RedheadDuckFactory;
import at.htl.interfaces.IQuackable;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator sim = new DuckSimulator();
        sim.simulate(new GooseFactory().createIQuackable());
        sim.simulate(new MullardDuckFactory().createIQuackable());
        sim.simulate(new RedheadDuckFactory().createIQuackable());


        QuackBuilder builder = new QuackBuilder();
        sim.simulate(builder.createGoose());
        sim.simulate(builder.createMullardDuck());
        sim.simulate(builder.createRedheadDuck());
        sim.simulate(builder.createRubberDuck());
        sim.simulate(builder.createQuackCountDecorator(builder.createRubberDuck()));

        System.out.println(QuackCountDecorator.count);
    }

    public void simulate(IQuackable quackable) {
        quackable.quack();
    }
}
