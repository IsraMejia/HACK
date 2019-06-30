var nombre = "Ana"
var nombreIsra = "Isra"

var ana ={
  nombre : "Ana",
  apellido : "Rafael",
  edad : 19
}

var isra ={
  nombre : "Isra",
  apellido : "Mejia",
  edad : 21
}

function imprimirMayus(nombre) {
  nombre = nombre.toUpperCase()
  console.log(nombre)
}

/*imprimirMayus(nombre)
imprimirMayus(nombreIsra)*/

imprimirMayus(isra.nombre)
imprimirMayus(ana.nombre)

function imprimirMayusObj({nombre}){
  // function imprimirMayusObj (persona){
  // var nombre = persona.nombre.toUpperCase()
  // console.log(persona.nombre.toUpperCase() + " //sacado del obj xd");
  console.log(nombre.toUpperCase());
}


imprimirMayusObj(ana)
imprimirMayusObj(isra)
imprimirMayusObj({nombre : "pepito"}) //Se crea el objeto al hacer la funicion
//imprimirMayusObj({apellido : "perez"}) //manda error al no tener apellido definido en la funcion
