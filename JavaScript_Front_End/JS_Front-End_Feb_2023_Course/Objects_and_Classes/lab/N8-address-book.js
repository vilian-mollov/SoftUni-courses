function storingInfoAboutPerson(input) {
    let contacts = {};

    //collecting data
    input.forEach(e => {
        let tokens = e.split(":");
        let [name, address] = tokens;
        
        contacts[name] = address;
    });

    //sorting
    let entries = Object.entries(contacts);

    entries.sort(([keyA, valueA], [keyB, valueB]) => 
        keyA.localeCompare(keyB));

    //back to object
    contacts = {};
    entries.forEach(e => {
        let [key,value] = e;
            contacts[key] = value;
    });

    //return sorted object by keys
    return contacts;
}


console.log(storingInfoAboutPerson(['Tim:Doe Crossing',
                        'Bill:Nelson Place',
                        'Peter:Carlyle Ave',
                        'Bill:Ornery Rd']));
