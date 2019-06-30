#include <Servo.h>
Servo servo;
int angle = 180;

void setup() {
  servo.attach(1);
  servo.write(angle);
}

void loop() { 
 // scan from 0 to 180 degrees
 servo.write(angle);  
 delay(1500); 
 servo.write(90);  
 delay(1500);
 Serial.println("90");
 servo.write(45);  
 delay(1500);
 servo.write(90);  
 delay(1500); 
 
  /*for(angle = 0; angle < 280; angle++)  
  {                                  
    servo.write(angle);               
    delay(5);                   
  } 
  // now scan back from 180 to 0 degrees
  for(angle = 280; angle > 10; angle--){                                
    servo.write(angle);           
    delay(5);       
  } */
}
