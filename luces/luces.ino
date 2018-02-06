#include <SoftwareSerial.h>
SoftwareSerial BT1(4,2);//RX, TX
int ledpin;

void admin_valor(int pin , char(t))
{
  if(pin >= 5 && pin < 13)
  {
    ledpin==pin;
    Serial.print(int(ledpin));
  }
  pin -= 48;
  
  if(t=='h' || t=='H')
  {
    digitalWrite(pin,HIGH);
    Serial.println(String(t));
  }
  if(t=='l' || t=='L')
  {
    digitalWrite(pin,LOW);
    Serial.println(String(t));
  }
  
}

void captura()
{
  if (BT1.available())
  {
           Serial.write(BT1.read());
  }    
  if (Serial.available())
   {  
      int pin = Serial.read();
      char estado= Serial.read();
      admin_valor(pin, estado);
   }
  
/*  while(BT1.available()==0)
  {
    delay(500);
  }
  while(BT1.available()>0)
  {
    int pin = Serial.read(BT1.read());
    char estado= Serial.read(BT1.read());
    admin_valor(pin, estado);
  }
*/ 
}



void setup()
{
  //int i;
  pinMode(3,OUTPUT);
  pinMode(4,OUTPUT);
  pinMode(5,OUTPUT);
  pinMode(6,OUTPUT);
  pinMode(7,OUTPUT);
  pinMode(8,OUTPUT);
  pinMode(9,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(11,OUTPUT);
  pinMode(12,OUTPUT);
  pinMode(13,OUTPUT);
  Serial.begin(4800);
  BT1.begin(9600);
  Serial.println("Esto es CS50x.ni");
  delay(1000); 
}
void loop()
{
  captura();
}
