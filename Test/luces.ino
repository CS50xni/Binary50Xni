int ledpin;

void admin_valor(int pin , char(t))
{
  int i;
  if(pin > 1 && pin < 10)
  {
    ledpin==pin;
  }
  pin -= 48;
  
  if(t=='h' || t=='H')
  {
    digitalWrite(pin,HIGH);
  }
  if(t=='l' || t=='L')
  {
    digitalWrite(pin,LOW);
  }
  if(t=='w' || t=='W')
  {
    println(String(t));
    for(i=2;i<10;i++)
    {
      digitalWrite('i',LOW);
      digitalWrite('i',HIGH);
      delay(1000);
      digitalWrite('i',LOW);
      delay(1000);
    }
    for(i=10;i>1;i--)
    {
      digitalWrite('i',HIGH);
      delay(1000);
      digitalWrite('i',LOW);
      delay(1000);
    }
  }
  
}

void captura()
{
  while(Serial.available()==0)
  {
    delay(100);
  }
  while(Serial.available()>0)
  {
    int pin = Serial.read();
    char estado= Serial.read();
    admin_valor(pin, estado);
  }
  
}



void setup()
{
  pinMode(2,OUTPUT);
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
  Serial.begin(9600);
}
void loop()
{
  captura();
}
