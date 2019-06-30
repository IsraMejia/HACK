console.log("-clase18-filtrarArreglos----------");

var ana = {
  nombre : "Ana -u-",
  apellido : "Rafael",
  altura : 1.54
}

var isra = {
  nombre:"Israel",
  apellido: " Mejía",
  altura :1.7
}

var rex= {
  nombre:"Rex",
  apellido: "Lucho",
  altura: 2.35
}

var coco = {
  nombre:"Coco",
  apellido: "cocomix",
  altura: .21
}

var alo  = {
  nombre:"Alo",
  apellido: "Mejia",
  altura: 1.65
}

// const esAlta = (persona) => {
//   return persona.altura > 1.8
// }
const esAlta = persona => persona.altura > 1.8

var personas = [ana, isra, alo, rex, coco]

var personasAltas = personas.filter(esAlta)
//se pone como condicion a una funcion, filter devuelve un nuevo
// array con los datos que pedimos en la condicion "esAlta"

console.log(personasAltas);
