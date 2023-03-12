class Song {
  constructor(typeList, name, time) {
    this.typeList = typeList;
    this.name = name;
    this.time = time;
  }
}

function filterSongs(input) {
  let songs = [];
  let [n, ...rest] = input;
  let listToShow = rest.pop();

  for (let i = 0; i < rest.length; i++) {
    let [type, name, time] = rest[i].split("_");

    let song = new Song(type, name, time);
    songs.push(song);
  }

  for (let i = 0; i < songs.length; i++) {
    if (listToShow === songs[i].typeList || listToShow === "all") {
      console.log(songs[i].name);
    }
  }
}


// First Example
console.log("First Example ---------------------");
filterSongs([4,
    'favourite_DownTown_3:14',
    'listenLater_Andalouse_3:24',
    'favourite_In To The Night_3:58',
    'favourite_Live It Up_3:48',
    'listenLater']);

// Second Example
console.log("Second Example ---------------------");
filterSongs([2,
    'like_Replay_3:15',
    'ban_Photoshop_3:48',
    'all']);
