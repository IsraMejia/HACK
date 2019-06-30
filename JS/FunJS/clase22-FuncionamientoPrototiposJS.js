console.log("clase22-FuncionamientoPrototiposJS.js");

function persona (nombre, apellido, altura){//prototipo-lo mas similar a una clase
  //aqui inicia el constructor del prototipo
  this.nombre = nombre
  this. apellido = apellido
  this.altura = altura
}
persona.prototype.saludar = function(){
  console.log(`Hola, me llamo ${this.nombre} ${this.apellido}`);
}

persona.prototype.soyAlto = () => this.altura > 1.64

/*Se recomienda definir el constructor, despues sus metodos al INICIO
y ya despues lo demas*/

var ana = new persona("Ana", "Rafael", 1.55) //new crea el objeto dado el protoripo
var isra = new persona("Isra", "Mejia",1.7)
//isra.saludar() //poner asi en consola para imprimir bien
var alo = new persona ("Alondra", "Mejia",1.65)
