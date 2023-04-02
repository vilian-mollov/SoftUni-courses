function getInfo() {
  const busStopId = document.getElementById("stopId").value;
  const url = "http://localhost:3030/jsonstore/bus/businfo/" + busStopId;
  const stopName = document.getElementById("stopName");
  const ulBuses = document.getElementById("buses");

  //1287 , 1308 , 1327, 2334

  fetch(url, { method: "GET" })
    .then((res) => res.json())
    .then((data) => {
      let name = data.name;
      let busesArr = data.buses;

      stopName.textContent = name;
      let entries = Object.entries(busesArr);

      entries.forEach((k) => {
        let li = document.createElement("li");
        li.textContent = "Bus " + k[0] + " arrives in " + k[1] + " minutes";
        ulBuses.appendChild(li);
      });
    })
    .catch((err) => {
      stopName.textContent = 'Error';
      console.error(url + "   404 Not Found!");
    });
}
