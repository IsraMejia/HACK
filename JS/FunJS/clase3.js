var edad = 21
edad +=1 //incremento
 var peso = 70
 peso -=2 //baje 3 kg
 var tacos = 1

peso += tacos
var jugarBasket = -2

peso += jugarBasket

var precioVino = 200.3
var total = Math.round(precioVino*3*100)/100
//se redondea se multiplica por 100 y se divide por lo mismo
//para que no hayan errores
var totalStr = total.toFixed(3) //tomar en cuenta 3 decimales
var total2 = parseFloat(totalStr)
/*pasar de string decimal a float*/

var pizza = 8
var persona = 2
var cantidadPorciones = pizza/persona
