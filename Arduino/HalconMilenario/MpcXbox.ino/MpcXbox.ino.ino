
#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>
#include <RF24_config.h>

RF24 radio(7, 8); // CE, CSN
const uint64_t pipe = 0xE9E9F0F0E1LL;
char msg[16] = "transmitiendo \n";

void setup(void){
  Serial.begin(9600);
  radio.begin();
  radio.openWritingPipe(pipe);
}

void loop(void){
  radio.write(msg,16);
  Serial.println("Se envio");
  Serial.println(msg);
}
