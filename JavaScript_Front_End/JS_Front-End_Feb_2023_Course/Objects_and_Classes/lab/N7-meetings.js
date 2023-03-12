function manageMeetings(input) {

    let meetingSchedule = {};

    input.forEach(couple => {
        let tokens = couple.split(" ");
        let [day, name] = tokens;

        if(meetingSchedule.hasOwnProperty(day)){
            console.log(`Conflict on ${day}!`);
        }else {
            meetingSchedule[day] = name;
            console.log(`Scheduled for ${day}`);
        }

    });


    for (const key in meetingSchedule) {
        console.log(`${key} -> ${meetingSchedule[key]}`);
    }

}

manageMeetings(["Monday Peter", 
                "Wednesday Bill", 
                "Monday Tim", 
                "Friday Tim"]);
