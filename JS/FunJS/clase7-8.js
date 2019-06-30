console.log("hola xD");


var ana =  {
  nombre: "Ana",
  apellido : "Rafael",
  edad : 19

}



//DESTROCTURACION CLASE7
function imprimirEnMayusDes(persona){
  var { nombre } = persona
  //Se le asigna a una variable nombre el atributo nombre del Objeto
  console.log(nombre.toUpperCase());
}

imprimirEnMayusDes(ana)

//Clase 8 -----------------------------------


function cumpleanos(persona){//recibeObjeto
  persona.edad += 1
}//pasa el objeto y este se modifica (parametro)

function cumpleanos(edad){ //recibe atributo
  edad += 1
}// pasa el valor de la edad y no se ve afectado el objeto


function cumpleanosViejo(persona){ //recibe objeto a Copiar/crear
  return{
    ...persona,
    edad : persona.edad + 1
  }//devuelve un nuevo objeto con un año mas que el anterior
  console.log(persona.edad);
}
/*Nos sirve para que nos devuelva un nuevo objeto
sin afectar el anterior */
