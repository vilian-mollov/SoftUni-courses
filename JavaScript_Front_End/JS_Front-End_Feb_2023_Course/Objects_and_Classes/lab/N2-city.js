function printObject (object) {
    let arr = Object.entries(object);

    arr.forEach(entry => {
        console.log(entry.join(" -> "));
    });
}

printObject({name: "Sofia",
area: 492,
population: 1238438,
country: "Bulgaria",
postCode: "1000"})