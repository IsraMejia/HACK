console.log("clase13-for-------------------------");

var isra ={
  nombre : "Israel",
  apellido : "Mejia",
  edad : 19,
  peso : 70
}
const INCREMENTO_PESO= .2
const DIAS_AÑO=365
const aumentarPeso = persona =>/*return*/  persona.peso += INCREMENTO_PESO
const adelgazar= persona => persona.peso -= INCREMENTO_PESO

console.log(`al inicio del año ${isra.nombre} pesa ${isra.peso} kg` );

for (var i=1; i<=DIAS_AÑO ; i++){
  var random = Math.random()
  if (random <0.25){//aumenta de peso
    aumentarPeso(isra)
  }else if(random < 0.50){ //va a adelgazar
    adelgazar(isra)
  }
}

console.log("Al final del año " + isra.nombre + " pesa " + isra.peso.toFixed(1) + "kg");
//.toFixed(2) solamente toma 2 lugares despues de la coma
