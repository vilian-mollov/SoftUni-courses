function printingTowsInfo(info) {

    info.forEach(element => {
        let tokens = element.split(" | ");
        let [town, latitude, longitude] = tokens;

        let obj = {town, latitude: Number(latitude).toFixed(2), longitude: Number(longitude).toFixed(2)};
        console.log(obj);
    });
}

printingTowsInfo(['Sofia | 42.696552 | 23.32601',
'Beijing | 39.913818 | 116.363625']);
