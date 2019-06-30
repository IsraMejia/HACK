/*Se asignan el numero del pin de arduino a las variables con los mismos
nombres que los puertos del sensor*/
const int Tring =  12;
const int Echo = 13;

void setup() {
  Serial.begin(9600);/*Estableciendo una conexion con el sensor ultrasonico*/
  pinMode(Tring, OUTPUT);/*Se configura el ping 12 (Trig) como de salida*/
  pinMode(Echo, INPUT); /*El puerto Echo servira para enviar informacion*/
}

void loop() {
  long duracion, distancia;
  digitalWrite(Tring, LOW); 
  delayMicroseconds(4);
  digitalWrite(Tring, HIGH);
  delayMicroseconds(10);
  digitalWrite(Tring, LOW);
  /*apaga el tring por 4 microsegundos para un disparo limpio de onda y se 
  vuelve a escribir para hacer una nueva lectura durante 10 msec y se apaga*/

  duracion = (pulseIn(Echo, HIGH))/2;
  /*HECHO hace el conteo en microsegundos y se guarda en duracion de lo que la onda
  tarda en ir y venir, si se divide en 2 solo es lo que se tarda en ir*/
/*1cm/29.2microseg  velocidad de la onda*/
  distancia = duracion/29;

  Serial.println(distancia);
  delay(50);
}
