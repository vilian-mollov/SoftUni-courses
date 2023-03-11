function setCity(name, population, treasury) {
  let city = { name, population, treasury, taxRate: 10 };

  city.collectTaxes = function () {
    this.treasury += this.population * this.taxRate;
    this.treasury = Math.round(this.treasury);
  };

  city.applyGrowth = function (percentage) {
    this.population += (this.population * percentage) / 100;
    this.population = Math.round(this.population);
  };

  city.applyRecession = function (percentage) {
    this.treasury -= (this.treasury * percentage) / 100;
    this.treasury = Math.round(this.treasury);
  };

  return city;
}

const city = setCity("Tortuga", 7000, 15000);

city.collectTaxes();
console.log(city.treasury);

city.applyGrowth(5);
console.log(city.population);
