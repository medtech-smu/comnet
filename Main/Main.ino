#include "Initialization.h"
#include "EstablishConnection.h"
#include "RunApp.h"


void setup()
{
  Serial.begin(9600);

  estabablishConnection();
  initialization ();
}

void loop() {
  switchState = digitalRead(buttonPin);
  runApp(switchState);
}

