console.log("clase21-PrototiposclasesJS------");

function persona (nombre, apellido, altura){//prototipo-lo mas similar a una clase
  //aqui inicia el constructor del prototipo
  this.nombre = nombre
  this. apellido = apellido
  this.edad = 20 //asi todos tienen 20
  this.altura = altura
}
persona.prototype.saludar = function(){
  console.log(`Hola, me llamo ${this.nombre} ${this.apellido}`);
}

var ana = new persona("Ana", "Rafael", "1.55") //new crea el objeto dado el protoripo
ana.saludar()

var isra = new persona("Isra", "Mejia")
//isra.saludar() //poner asi en consola para imprimir bien
var alo = new persona ("Alondra", "Mejia")
