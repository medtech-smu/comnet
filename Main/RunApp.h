#include <BlynkSimpleMKR1000.h>

// When you click on the button
void runApp (int switchState){
  Blynk.run();
  if (switchState == HIGH) {
    BLYNK_LOG("Button is pressed.");
    Blynk.notify("Please open up! Somebody is on the door!"); //Get notification every 15 secs
    lcd.clear(); //Use it to clear the LCD Widget
    lcd.print(0, 0, "Open The Door!"); // use: (position X: 0-15, position Y: 0-1, "Message you want to print")
  }
}

BLYNK_WRITE(V2) {
  if (param.asInt()) {
    digitalWrite(greenLedPin, HIGH);
    digitalWrite(redLedPin, LOW);
    myLock.write(90); //The lock turns 90 degrees
    lcd.clear();
    lcd.print(1, 0, "Door unlocked");
    delay(5000);
    myLock.write(0); //The lock returns to its initial state
    digitalWrite(greenLedPin, LOW);
    digitalWrite(redLedPin, HIGH);
    lcd.clear();
    lcd.print(2, 0, "Door locked");
    delay(3000);
    lcd.clear();
    lcd.print(4, 0, "Connected!");
  }
}
