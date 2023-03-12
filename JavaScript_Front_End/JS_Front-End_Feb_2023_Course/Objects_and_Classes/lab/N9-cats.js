class Cat {

    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    meow() {
        console.log(`${this.name}, age ${this.age} says Meow`);
    }

}


function createCats(arrInput) {

    arrInput.forEach(e => {
        let tokens = e;
        let [name, age] = tokens.split(" ");
        let cat = new Cat(name, age);
        cat.meow();
    });

}



createCats(['Mellow 2', 'Tom 5']);




