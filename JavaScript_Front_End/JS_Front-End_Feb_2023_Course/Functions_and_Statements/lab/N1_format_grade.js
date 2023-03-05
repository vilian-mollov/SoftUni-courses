let grade = 6;

function formatGrade(grade) {
    if (grade > 6 || grade < 2) {
        return "Invalid grade!!!"
    }
    if(grade >= 5.50 && grade <= 6.00){
        return `Excellent (${grade.toFixed(2)})`;
    } else if (grade >= 4.50) {
        return `Very good (${grade.toFixed(2)})`;
    } else if (grade >= 3.50) {
        return `Good (${grade.toFixed(2)})`;
    } else if (grade >= 3.00) {
        return `Poor (${grade.toFixed(2)})`;
    } else if (grade >= 2.00) {
        return `Fail (2)`;
    }
}


console.log(formatGrade(17));