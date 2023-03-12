function manageMeetings(input) {

    let assocArr = {};

    input.forEach(couple => {
        let tokens = couple.split(" ");
        let [day, name] = tokens;

        if(assocArr.hasOwnProperty(day)){
            console.log(`Conflict on ${day}!`);
        }else {
            assocArr[day] = name;
            console.log(`Scheduled for ${day}`);
        }

    });


    for (const key in assocArr) {
        console.log(`${key} -> ${assocArr[key]}`);
    }

}

manageMeetings(["Monday Peter", 
                "Wednesday Bill", 
                "Monday Tim", 
                "Friday Tim"]);
