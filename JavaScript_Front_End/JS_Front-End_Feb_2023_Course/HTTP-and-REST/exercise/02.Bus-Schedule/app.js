function solve() {
  const departEl = document.getElementById("depart");
  const arriveEl = document.getElementById("arrive");
  let station = "depot";
  const BASE_URL = "http://localhost:3030/jsonstore/bus/schedule/";
  const span = document.querySelector("div#info span.info");

  function depart() {
    const url = BASE_URL + station;

    fetch(url, { method: "GET" })
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        span.textContent = "Next stop " + data.name;
        departEl.setAttribute("disabled", "true");
        arriveEl.removeAttribute("disabled");
      })
      .catch((err) => {
        span.textContent = 'Error';
        arriveEl.setAttribute("disabled", "true");
        departEl.setAttribute("disabled", "true");
        console.error(err);
      });
  }

  async function arrive() {
    const url = BASE_URL + station;

    try {
      const response = await fetch(url);
      const data = await response.json();
      span.textContent = "Arriving at " + data.name;
      arriveEl.setAttribute("disabled", "true");
      departEl.removeAttribute("disabled");
      station = data.next;

    } catch (err) {
        span.textContent = 'Error';
        arriveEl.setAttribute("disabled", "true");
        departEl.setAttribute("disabled", "true");
        console.error(err);
    }
  }

  return {
    depart,
    arrive,
  };
}

let result = solve();
