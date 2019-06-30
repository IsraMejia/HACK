
#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>
#include <RF24_config.h>

char msg[16];
RF24 radio(7, 8); // CE, CSN
const uint64_t pipe = 0xE9E9F0F0E1LL;

void setup(void){
  Serial.begin(9600);
  radio.begin();
  radio.openReadingPipe(1,pipe);
  radio.startListening();
}

void loop(void){

  if(radio.available()) {
    radio.read(msg, 16);
    Serial.println(msg);
  }else{
    Serial.println("No esta disponible la linea");
  }
  
}
