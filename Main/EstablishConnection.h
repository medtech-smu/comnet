#define BLYNK_PRINT Serial
#include <SPI.h>
#include <WiFi101.h>
#include <BlynkSimpleMKR1000.h>

//Virtual LCD widget on Blynk
WidgetLCD lcd(V1);

void estabablishConnection() {
  // Your WiFi credentials.
  //char ssid[] = "************";
  //char pass[] = "*************";


  //char auth[] = "********";
  
  Blynk.begin(auth, ssid, pass);
  lcd.clear(); //Use it to clear the LCD Widget
  lcd.print(4, 0, "Connected!"); // use: (position X: 0-15, position Y: 0-1,     "Message you want to print") 
}
