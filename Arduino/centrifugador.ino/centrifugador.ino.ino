
int v = 200;//150
int m =6;
void setup() {   
  pinMode(m, OUTPUT);//Pin del motor
  Serial.begin(9600);
  analogWrite(m,0); //parar motor pin 3->atras
}

void loop() {
  
  analogWrite(m,v);
  delay(9000);
 
  for (v=200; v<=250; v+=10){
    analogWrite(m,v);
    Serial.write(v);
    delay(9000);
  }/*
  for(v=250; v>=200 ; v-=10){
    analogWrite(m,v);
    Serial.write(v);
    delay(5000);
  }*/
  
}
