console.log("-clase17-Arreglos----------");

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
  altura: .35
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

var personas = [ana, isra, alo, rex, coco]


for(var i = 0;i<personas.length; i++){
  var persona = personas[i]
  console.log(`${persona.nombre} mide ${persona.altura} metros`);

}
prompt("ana quiere saber tu ubicacion xd")
