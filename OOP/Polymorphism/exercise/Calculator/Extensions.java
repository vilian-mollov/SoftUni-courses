package Polymorphism.exercise.Calculator;

public class Extensions {

    public static InputInterpreter buildInterpreter(CalculationEngine engine){
        return new InputInterpreter(engine);
    }
}
