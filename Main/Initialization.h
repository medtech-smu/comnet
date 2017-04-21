#include <Servo.h>
Servo myLock;
int switchState = 0;
int greenLedPin = 1;
int redLedPin = 2;
int servoPin = 6;
int buttonPin = 0;

void initialization () {
  //Define the functionality of the pins used in the Hardware Side
  pinMode(buttonPin, INPUT);
  pinMode(greenLedPin, OUTPUT);
  pinMode(redLedPin, OUTPUT);

  // Initilization
  myLock.attach (servoPin);
  myLock.write (0);
  digitalWrite(greenLedPin, LOW);
  digitalWrite(redLedPin, HIGH);
}

