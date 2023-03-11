function setPerson (firstName, lastName, age) {
    let person = {firstName,lastName,age};
    person.firstName = firstName;
    person.lastName = lastName;
    person.age = age;

    return person;
}

console.log(setPerson("Peter", "Pan", "20"));
