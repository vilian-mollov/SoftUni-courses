function storingEmployees(nameList) {

    Object.entries(
        nameList.reduce((data, employee) => {
            data[employee] = employee.length;
            return data;
        }, {})
    ).forEach(([employee, length]) => {
        console.log(`Name: ${employee} -- Personal Number: ${length}`)
    })
    
}

storingEmployees([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]);