class Movie {
    constructor(name) {
      this.name = name;
      this.director;
      this.date;
    }
  
    addDirector(director) {
      this.director = director;
    }
  
    addDate(date) {
      this.date = date;
    }
  }

function processInfo(info) {
   
  let movies = [];

  for (const line of info) {
    let data = line.split(" ");

    if (data[0] === "addMovie") {
      let name = data.slice(1).join(" ");
      let movie = new Movie(name);
      movies.push(movie);
    } else if (data.includes("directedBy")) {
      let indexOfDirected = data.indexOf("directedBy");
      let name = data.slice(0, indexOfDirected).join(" ");
      let director = data.slice(indexOfDirected + 1).join(" ");
      for (const mov of movies) {
        if (mov.name === name) {
          mov.addDirector(director);
        }
      }
    } else {
      let indexOfDate = data.indexOf("onDate");
      let name = data.slice(0, indexOfDate).join(" ");
      let date = data.slice(indexOfDate + 1).join(" ");
      for (const mov of movies) {
        if (mov.name === name) {
          mov.addDate(date);
        }
      }
    }
  }

 
  for (const movie of movies) {
    console.log(movie);
  }
}

processInfo([
  "addMovie Fast and Furious",
  "addMovie Godfather",
  "Inception directedBy Christopher Nolan",
  "Godfather directedBy Francis Ford Coppola",
  "Godfather onDate 29.07.2018",
  "Fast and Furious onDate 30.07.2018",
  "Batman onDate 01.08.2018",
  "Fast and Furious directedBy Rob Cohen",
]);
