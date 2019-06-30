console.log("clase14-while-------------------------");

var isra ={
  nombre : "Israel",
  apellido : "Mejia",
  edad : 19,
  peso : 70
}
const INCREMENTO_PESO= .3
const DIAS_AÑO=365

const aumentarPeso = persona =>/*return*/  persona.peso += INCREMENTO_PESO
const adelgazar= persona => persona.peso -= INCREMENTO_PESO
const entreno =() => Math.random()<0.5
const nodurmio=() => Math.random()<0.1

console.log(`al inicio del año ${isra.nombre} pesa ${isra.peso} kg` );

const META = isra.peso+2
var dias = 0

while(isra.peso <= META){
  debugger
  if(entreno()){//aumenta
    aumentarPeso(isra)
  }
  if(nodurmio()){//adelgazar
    adelgazar(isra)
  }
  dias+=1
}

console.log("despues de " + dias + " dias" +isra.nombre+ "pesa" + isra.peso.toFixed(1) + "kg");
//.toFixed(2) solamente toma 2 lugares despues de la coma
