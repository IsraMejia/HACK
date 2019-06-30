#include <Arduino.h>
#include <Wire.h>
#include <SoftwareSerial.h>

#include <LiquidCrystal_I2C.h>

double angle_rad = PI/180.0;
double angle_deg = 180.0/PI;
double dist1;
double vel;
double dist2;
LiquidCrystal_I2C lcd_I2C_0x30(0x30, 2, 1, 0, 4, 5, 6, 7, 3, POSITIVE);
float getDistance(int trig,int echo){
pinMode(trig,OUTPUT);
digitalWrite(trig,LOW);
delayMicroseconds(2);
digitalWrite(trig,HIGH);
delayMicroseconds(10);
digitalWrite(trig,LOW);
pinMode(echo, INPUT);
return pulseIn(echo,HIGH,30000)/58.0;
}

void setup(){
lcd_I2C_0x30.begin(16, 2);

}

void loop(){

lcd_I2C_0x30.clear();
lcd_I2C_0x30.setCursor( (4) – 1, (1) – 1 );
lcd_I2C_0x30.print( «RADAR DE» );
lcd_I2C_0x30.setCursor( (4) – 1, (2) – 1 );
lcd_I2C_0x30.print( «VELOCIDAD» );
dist1 = 0;
vel = 0;
dist2 = 0;
while(!((getDistance(8,9)) < (50)))
{
_loop();
}
dist1 = getDistance(8,9);
_delay(0.1);
dist2 = getDistance(8,9);
vel = ((dist1) – (dist2)) / (0.1);
_delay(0.5);
lcd_I2C_0x30.clear();
lcd_I2C_0x30.setCursor( (3) – 1, (1) – 1 );
lcd_I2C_0x30.print( «SU VELOCIDAD» );
lcd_I2C_0x30.setCursor( (3) – 1, (2) – 1 );
lcd_I2C_0x30.print( vel );
lcd_I2C_0x30.setCursor( (10) – 1, (2) – 1 );
lcd_I2C_0x30.print( «cm/seg» );
_delay(3);

_loop();
}

void _delay(float seconds){
long endTime = millis() + seconds * 1000;
while(millis() < endTime)_loop();
}

void _loop(){

}
