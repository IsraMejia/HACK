console.log("clase24-HerenciaPrototipalJS-------");

function heredaDe(prototipoHijo, prototipoPadre ){
  var fn = function (){}//funcion vacia que recibe a protitipo prototipoPadre
  fn.prototype = prototipoPadre.prototype
  prototipoHijo.prototype = new fn
  prototipoHijo.prototype.constructor = prototipoHijo
}

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
}/*recomienda usar funciones normales en los objetos y NO con arrowFunctios*/


function Desarrollador(nombre,apellido){
  this.nombre = nombre
  this. apellido = apellido
}

heredaDe (Desarrollador , persona)
/*el mecanismo de herencia se hace inmediatamente despues del constructor
de la clase hija para que sus metodos esten separados
Se le puede pasar la altura al Desarrollador sin importar que no tiene
este atributo declarado en su constructor ya que lo hereda de persona*/
Desarrollador.prototype.saludar = function(){
  console.log(`Hola me llamo ${this.nombre} ${this.apellido} y soy Desarrollador`);
}

/*
var ana = new persona("Ana", "Rafael", 1.55) //new crea el objeto dado el protoripo
var isra = new persona("Isra", "Mejia",1.7)
var alo = new persona ("Alondra", "Mejia",1.65)
*/
