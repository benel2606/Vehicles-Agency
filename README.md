# Vehicle management agency

### Introduction
System development for a vehicle management agency - Using **JAVA** language, using different ***DP's***, which supports ***multi-threading*** and a ***GUI interface***.

### System features
#### Perform 4 operations on many vehicles:
+ ***Operations:***
  * Add new Vehices - adding new vehicles to the vehicles inventory.
  * Buy vehicle - buying vehicle from  the vehicles inventory.
  * Test drive - take a vehicles from the vehicles inventory to test drive.
  * Change flag - if the vehicle is sea vehicles then you can change his flag.
+ ***Vehicles:***
  * Jeep
  * Frigate
  * Spy glider
  * Toy glider
  * Amphibious
  * Bicycle
  * Cruise ship
  * Hybrid aircraft
  * Elctric bicycle
+ ***System operations:***
  * Reset mileage - reset all the mileage after the test drive.
  * Show vehicles inventory - show all vehicles that exists in the vehicles inventory.
  * Save cuttrnt state - save the current system state with the vehicles inventory, mileage and all changes.
  * Back to previous state - You can go back up to 3 state.
  
  ### Design Patterns:
  The system using diffrent design patterns:
  
|Design Pattern  | Use |
| :-------------: | ------------- |
| **Singlethon**  | Implementing in "main menu" window to limit the number of windows  |
| **Deligator**  | Using to avoid multiple inheritance   |
| **Decorator** | Using to adding a vehicle color and a vehicle status in run-time |
| **Memento** | Using to saving 3 state and to return to the State|
| **Abstract factory** | Using to producing new vehicles and to make sure that the system is expandable |
| **Observer**| Using to calculating the total mileage of all vehicles test drive |
| **Thread pool**| Using to limit the number of test drive windows |

###ScreenShots

  
  


