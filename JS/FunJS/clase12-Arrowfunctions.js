console.log("clase12-Arrowfunctions");
var ana={
  nombre:"Ana",
  apellido : "Rafale",
  edad : 19
}
var Isra={
  nombre:"Israel",
  apellido : "Mejia",
  edad : 21
}
var juan ={
  nombre : "juan",
  edad : 13
}

const MAYORIA_EDAD =18
//OJO Y OREJA------------------------------------------
// Arrowfunctions-----------------------------
//const esMayorEdad  = function (persona){ //se vale
/*const esMayorEdad = persona => { //forma recomendada
  return persona.edad >= MAYORIA_EDAD
}*/
//forma ULTRAHACKERPROOOO:O
//const esMayorEdad = persona => persona.edad >= MAYORIA_EDAD
const esMayorEdad = ({edad}) => edad >= MAYORIA_EDAD

/*
Se le asigna a una variable una funcion anonima = sin nombre
a pesar que la variable si tiene nombre
se reconienda hacerla constante para que sea mas facil

la funcion se hizo una constante que se le asigna el boolean del resultado
de comparar la edad del objeto persona
En la UlimateHacker, se desestructura el objeto ya que solo nos interesa
su atributo edad
*/

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


function permitirAcceso(persona){
  if(!esMayorEdad(persona)){ //si no es mayor de edad
    console.log("Acceso denegado By");
  }
}

permitirAcceso (ana)
permitirAcceso(juan)
