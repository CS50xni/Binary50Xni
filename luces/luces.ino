int ledpin;
int pin_inicial=2;
int pin_final=10;

void reset ()
{
  int i;
  for(i=pin_inicial;i<pin_final;i++)
  {
    digitalWrite(i,LOW);
  }
}

void admin_valor(int pin , char(t))
{
  int i;
  if(pin >= 0 && pin < 10)
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
  if(pin==0)
  {
    reset();
  }
  else if(pin==1)
  {
    reset();
    for(i=pin_inicial;i<pin_final;i++)
    {
      digitalWrite(i,HIGH);
      delay(300);
      digitalWrite(i,LOW); 
      delay(300);
    }
    for(i=pin_final;i>=pin_inicial;i--)
    {
      digitalWrite(i,HIGH);
      delay(300);
      digitalWrite(i,LOW); 
      delay(300);
    }
  }
}

void captura()
{
  if(Serial.available()==null)
  {
    delay(100);
  }
  if(Serial.available()!=null)
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
  Serial.begin(9600);
}
void loop()
{
  captura();
}
