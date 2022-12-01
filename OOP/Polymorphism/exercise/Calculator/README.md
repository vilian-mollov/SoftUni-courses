# Calculator
You are given the skeleton of a calculator program (like the Calculator app in Windows, or the calculator on your <br>
smartphone, etc.). The program reads numbers and operations from the console and executes those operations on <br>
the numbers. The numbers are positive integers, while the operations can be single symbols (e.g. the star symbol **'\*'** <br>
means multiplication), or strings of characters (e.g. the operation **"end"** stops the program and prints out the result).<br>

Operations are executed immediately after they receive all their needed operands. For example, the expression **3 * 4 / 2 will** <br>
first store **3**, then see the multiplication and wait for a number to multiply – when it receives 4 it will calculate **3 * 4 = 12**,<br>
then see the division and wait for a number to divide by – when it receives **2**, it will divide **12 by 2**. <br>
Any number input overwrites the current result of the calculator, just like in normal calculators. <br>
For example, if the expression **3 1 * 4 16 / 2** is input, we’d first have **3**, overwrite it with **1**, multiply by **4** and get **4**, <br>
but then we overwrite with **16** and divide that by **2** – the result will be **8**.<br>
<br>
The skeleton you are provided with contains the following files:
- **Main.java** – contains the main(String[] args) method, reads input, and prints output on the console
- **Operation.java** – contains a base class for any operation done by the calculator
- **MultiplicationOperation.java** – defines a class that inherits the base Operation class and implements the  <br>
multiplication operation (*)
- **CalculationEngine.java** – defines the calculator’s central logic of handling number and operations input
- **InputInterpreter.java** – defines a class that can interpret a string into either a number or an operation and <br>
invoke the engine accordingly
The files you are given support all logic necessary to implement the multiplication operation, as well as console <br>
input and output (note that input items don’t need to be on the same line – you can write 1 operation or number per line<br>
and the code will still work) but are missing the logic to instantiate an InputInterpreter, which should be defined in the missing **Extensions.java** file.
Your task is to study the provided code and add the following operations:
- **/** – **division**, divides the current result of the calculator by the next number the calculator receives and pushes the <br>
result to the calculator (i.e. same as multiplication, but divides).
- **ms** – saves the current result of the calculator to **"memory"**. The result of this operation is the current result of the calculator. <br>
For example, the expression 3 * 4 ms * 5 and the expression 3 * 4 * 5 are equivalent in their result.
- **mr** – **memory recall**, removes the last item from memory and sends it to the calculator. Note that this operation can be used <br>
in combination with other operations, for example, the expression **3 ms * 4 ms * 5 * mr * mr** will save 3 to memory, <br>
calculate to 12, save to memory, calculate 60, multiply that by 12 from memory, resulting in 720, <br>
then multiply that by 3 from memory, resulting in 2160. It can also be used without operations –  3 ms 4 mr is the same as 3 4 3.
## Input
The program defined in Main.java reads the following input:  
Strings, representing numbers or operations, separated by spaces (or new lines, or any "blank" space), ending <br>with the string "end".
## Output
The program defined in Main.java writes the following output:  
The calculated result of all the numbers and operations from the input.
## Restrictions
The numbers in the input will always be positive integers and no operation will result in a number larger than **1 billion**.
There will always be at least 1 ms operation before any mr operation. <br>
There will be no more mr operations than the preceding ms operations. <br>
There will be no ms operation following an operation expecting a value **(e.g. 3 * ms 4 is not a valid input, but 3 ms * 4 is)**.<br>
There will never be an invalid series of operations **(e.g. 3 / / 4, or 3 * * 4, etc.)**
The first 40% of the tests will NOT contain ms or mr operations.
The total running time of your program should be no more than 0.1s. 
The total memory allowed for use by your program is 16MB.
## Example

**Input**  
1 * 2 * 3 ms * 4 * mr / 2 end  
**Output**    
72  

**Input**  
12 / 3 ms / 2 ms * 5 mr * mr end  
**Output**  
8  