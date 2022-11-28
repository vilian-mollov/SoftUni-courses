# Wild Farm problem 

Your task is to create a class hierarchy like the picture below. All the classes except Vegetable, Meat, Mouse, Tiger, Cat & Zebra should be abstract.
Input should be read from the console. Every Odd line will contain information about the Animal in following format:
"{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion}".
If the animai is a cat: "{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} {CatBreed}".
On the Even lines, you will receive information about the food that you should give to the Animal. The line will consist of FoodType and quantity separated by whitespace.
You should build the logic to determine if the animal is going to eat the provided food. The Mouse and Zebra should check if the food is Vegetable. If it is they will eat it. Otherwise, you should print a message in the format:
"{AnimalType} are not eating that type of food!". 
Cats eat any kind of food, but Tigers accept only Meat. If a Vegetable is provided to a tiger message like the one above should be printed on the console.
After you read information about the Animal and Food then invoke makeSound() method of the current animal and then feed it. Proceed to read information about the next animal/food. The input will continue until you receive "End".
In the end, print all animal objects in the format:
"{AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".
If the animal is a cat: "{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".
Note: consider overriding toString() method.


**Input**			
Tiger Tom 167.7 Asia
Vegetable 1
Tiger Com 167.7 Asia
Meat 17
Zebra Jaguar 500 Africa
Vegetable 150
Cat Gray 1.1 Home Persian
Vegetable 4
Mouse Jerry 0.5 Anywhere
Vegetable 0
End

**Output**
ROAARRR!!!
Tiger are not eating that type of food!
ROAARRR!!!
Nom nom nom...
Zs
Nom nom nom...
Meowwww
Nom nom nom...
SQUEEEAAAK!
Nom nom nom...

Tiger [Tom, 167,70, Asia, 0]
Tiger [Com, 167,70, Asia, 17]
Zebra [Jaguar, 500,00, Africa, 150]
Cat[Gray, Persian, 1,10, Home, 4]
Mouse [Jerry, 0,50, Anywhere, 0]
