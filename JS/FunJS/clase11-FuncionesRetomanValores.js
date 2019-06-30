console.log("clase 11");

var ana={
  nombre:"Ana",
  apellido : "Rafale",
  edad : 19,
  ingeniero : false,
  qfb: true,
  cocinero :false,
  cantante : true,
  dj : true,
  guitarrista : false,
  drone : true
}

var isra ={
  nombre:"Israel",
  apellido : "Mejia",
  edad : 21,
  ingeniero : true,
  cocinero :true,
  cantante : true,
  dj : false,
  guitarrista : false,
  drone : true
}

var juan ={
  nombre : "juan",
  edad : 13
}

function imprimirProfesiones(persona){
  console.log(`${persona.nombre} es: `);

  if (persona.ingeniero){
    console.log("Ingeniero")
  }
  if (persona.qfb){
    console.log("Quimica Farmaco Biologa")
  }
  if (persona.cocinero){
    console.log("cocinero")
  }
  if (persona.cantante){
    console.log("cantante")
  }
  if (persona.dj){
    console.log("dj")
  }
  if (persona.guitarrista){
    console.log("guitarrista")
  }
  if (persona.drone){
    console.log("volador de drones")
  }else{
    console.log("No vuela dromes");
  }

}

imprimirProfesiones(ana)
console.log(" ");
imprimirProfesiones(isra)

function Mayor(persona){
  if (persona.edad > 20){
    console.log("Es mayor a 20");
  }else{
    console.log("es menor a 20 -u-");
  }
}
console.log("");
console.log("ana es mayor?");
Mayor(ana)
console.log("Isra es mayor?");
Mayor(isra)


const MAYORIA_EDAD =18

function esMayorEdad (persona){
  return persona.edad >= MAYORIA_EDAD
}

function imprimirSiEsMayor (persona){
  if (esMayorEdad(persona)){
    console.log(`${persona.nombre} es mayor de edad`);
  }else{
    console.log(`${persona.nombre} es manor de edad`);
  }
}

console.log("");
imprimirSiEsMayor(ana)
imprimirSiEsMayor(juan)
