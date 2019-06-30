console.log("clase25-ClasesJS----");

class Persona {
  constructor(nombre, apellido, altura){
    //aqui inicia el constructor del prototipo
    this.nombre = nombre
    this. apellido = apellido
    this.altura = altura
  }

  saludar(){
  console.log(`Hola, me llamo ${this.nombre} ${this.apellido}`);
  }

  soyAlto(){
      return this.altura > 1.64
  }

}

class Desarrollador extends Persona {//Herencia By
  constructor(nombre, apellido, altura){
    super (nombre,apellido,altura)
    //se le llama al constructor de la clase padre
    //despues de esto ya se puede usar this
  }

  saludar(){
    console.log(`Hola me llamo ${this.nombre} ${this.apellido} y soy Desarrollador`);
  }

}//Clase Desarrollador


/*
var ana = new Persona("Ana", "Rafael", 1.55) //new crea el objeto dado el protoripo
var isra = new Persona("Isra", "Mejia",1.7) //var isra = new Desarrollador("Isra", "Mejia",1.7)
var alo = new Persona ("Alondra", "Mejia",1.65)
*/
