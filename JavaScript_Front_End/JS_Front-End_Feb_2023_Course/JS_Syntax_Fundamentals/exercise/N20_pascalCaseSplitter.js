let text = 'SplitMeIfYouCanHaHaYouCantOrYouCan';

function pascalSplitting(text) {
    let reg = /[A-Z][a-z]*/g;
    let x = text.matchAll(reg);

    return [...x].join(", ");
}


console.log(pascalSplitting(text));
console.log(pascalSplitting('HoldTheDoor'));