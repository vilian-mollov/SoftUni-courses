package Polymorphism.exercise.Calculator;

public class MemorySaveOperation implements Operation{

    private Integer result;
    @Override
    public void addOperand(int operand) {
        this.result = operand;
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public boolean isCompleted() {
        return result != null;
    }
}
