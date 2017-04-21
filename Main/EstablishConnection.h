#define BLYNK_PRINT Serial
#include <SPI.h>
#include <WiFi101.h>
#include <BlynkSimpleMKR1000.h>

//Virtual LCD widget on Blynk
WidgetLCD lcd(V1);

void estabablishConnection() {
  // Your WiFi credentials.
  //char ssid[] = "Guest";
  //char pass[] = "123456789";
  char ssid[] = "Galaxy Alpha FH";
  char pass[] = "fh1995fh";
  //char ssid[] = "Comtrend_FH";
  //char pass[] = "fedi2010FAHMI";

  //char auth[] = "bd5476610aac40f8883d1ed2ca55db05";
  char auth[] = "2d84c97c79a641eeae6150aefa02e668";
  
  Blynk.begin(auth, ssid, pass);
  lcd.clear(); //Use it to clear the LCD Widget
  lcd.print(4, 0, "Connected!"); // use: (position X: 0-15, position Y: 0-1,     "Message you want to print") 
}
