package Polymorphism.exercise.Calculator;

import java.util.ArrayDeque;

public class CalculationEngine {
    private int result;
    private Operation currentOperation;

    private ArrayDeque<Integer> memory;

    public CalculationEngine(){
        this.result = 0;
        this.currentOperation = null;
        memory = new ArrayDeque<>();
    }

   public void pushNumber(int number) {
        if (this.currentOperation != null) {
            currentOperation.addOperand(number);

            if (currentOperation.isCompleted()) {
                this.result = currentOperation.getResult();
                addToMemoryIfMemorySaveOperation();
                this.currentOperation = null;
            }
        } else {
            this.result = number;
        }
    }

    void pushOperation(Operation operation) {
        if(operation == null){
            return;
        }
        if(operation instanceof MemoryRecall){
            this.pushNumber(memory.pop());
            return;
        }

        if (operation.isCompleted()) {
            this.pushNumber(operation.getResult());
        } else {
            this.currentOperation = operation;
            this.pushNumber(this.result);
        }
    }

    int getCurrentResult() {
        return this.result;
    }

    private void addToMemoryIfMemorySaveOperation() {
        if(currentOperation instanceof MemorySaveOperation){
            memory.push(currentOperation.getResult());
        }
    }
}
