int sensorTemp 		= 0;
int sensorUmidade 	= 0;
int sensorLumin 	= 0;

void setup()
{
  pinMode(A0, INPUT);
  pinMode(A1, INPUT);
  pinMode(A5, INPUT);
  Serial.begin(9600);

}

void loop()
{
  sensorTemp 	= map(analogRead(A0), 0, 358, 1, 100);
  sensorUmidade = map(analogRead(A1), 0, 539, 1, 100);
  sensorLumin 	= map(analogRead(A5), 0, 1023, 1, 100);

  Serial.print("temp:" );
  Serial.print(sensorTemp);
  delay(500);

  Serial.print("\n");
  Serial.print("umid:");
  Serial.print(sensorUmidade);
  Serial.print("\n");

  Serial.print("lumin:");
  Serial.print(sensorLumin);
  Serial.print("\n");


  delay(500);

}
