console.log("clase23-thisProtipos------");

function persona (nombre, apellido, altura){//prototipo-lo mas similar a una clase
  //aqui inicia el constructor del prototipo
  this.nombre = nombre
  this. apellido = apellido
  this.altura = altura
}
persona.prototype.saludar = function(){
  console.log(`Hola, me llamo ${this.nombre} ${this.apellido}`);
}

persona.prototype.soyAlto = function() {
  return this.altura > 1.64
}/*Al usar un arrow function this apunta a this del
espacio igual this === window , por lo que no apunta
al atributo del objeto que damos en al llamar la funcion

por lo que se recomienda usar funciones normales en los objetos*/

var ana = new persona("Ana", "Rafael", 1.55) //new crea el objeto dado el protoripo
var isra = new persona("Isra", "Mejia",1.7)
var alo = new persona ("Alondra", "Mejia",1.65)
