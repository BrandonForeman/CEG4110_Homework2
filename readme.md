###CEG4110: Homework 2

Github Link: https://github.com/BrandonForeman/CEG4110_Homework2

----

### Introduction:

This project design is broken up into three major pieces:

1. Implementation of Model, View, Controller and Command design patterns
2. Implementation of a digital and analog clock
3. Tying the clocks and the design patterns together



The functionality of the project is as follows:

1. A user is able to create a digital or analog clock. The clocks created are tied to a single date and time.
2. The all created analog and digital clocks appear on a single view. 
3. A user is able to change the clock time and date and the changes will occur to all created analog and digital clocks.
4. A user can undo and redo a clock time and date change or adding a digital or analog clock. The amount of undo's and redo's are unbounded.

---

### Deployment and Setup Instructions

##### External Dependencies

This project has one external dependency. It is a library called CustomAnalogClockView. This library is responsible for analog clock in the project.

The installation for this library is as follows:

1. Goto this github webpage: https://github.com/rosenpin/custom-analog-clock-view

2. Add the JitPack repository to your build file in your root gradle file

   ![setupStep1](C:\Users\Brandon\Desktop\HW2 Images\Photos\setupStep1.png)

3. Add the dependency to the library in your apps gradle file. This will be different from the gradle file from part 2. 

   ![deployment1](C:\Users\Brandon\Desktop\HW2 Images\deployment1.PNG)

   Now you're all set! You can now use all the CustomAnalogClockView object included with this library. For more information on how to use the library's, refer to the github page in step one

##### Installing the Application

### Setting up the Project

| To deploy the app to your device, follow these instructions: |
| ---------------------------------------- |
| 1. Move the Homework2.apk executable to your mobile device by any method. |
| 2. Open and run the Homework2.apk by clicking on it |
| 3. Allow access to unknown apps in your settings.<br />![deployment_step1](C:\Users\Brandon\Desktop\HW2 Images\deployment_step1.jpg) |
| 4. Now install the application via any means |

---

### Using the Application

The application only has one view. The upper portion of the view contains the controls for the clocks. The lower portion of the view displays the created clocks.

| Main screen:                             |
| ---------------------------------------- |
| This is the screen you will see when you start up the application.![instructions1](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions1.jpg) |
| 1. Add a digital clock by selecting "Add Digital Clock". |
| Click "Add Digital Clock".<br />![instructions1_edit](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions1_edit.jpg)<br />You can see a digital clock appear in the lower portion of the screen. The initial time of the clocks defaults to the device's current time. **Keep in mind there is a small amount of delay between the clock view's instantiation time and the device's time.** **Therefore the clock views may be a second off from the actual time.**<br />![instructions2](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions2.jpg) |
| 2. Add an analog clock by selecting "Add Analog Clock". |
| Click "Add Analog Clock"<br />![instructions2.1_edit](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions2.1_edit.jpg)<br />You can see an analog clock appear in the lower portion of the screen. This clock is the same time as the digital clock's time.<br />![instructions3](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions3.jpg) |
| 3. Changing the time                     |
| Change "00:00:00" plain text to be the new desired time in the format of "hour:minute:second"  then select "Change Time".<br />![instructions3_edit](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions3_edit.jpg)<br />You can see that both clocks times have been updated.<br />![instructions4](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions4.jpg) |
| 4. Changing the date                     |
| Change "1/1/2018" plain text to be the new desired date in the format "Month/Day/Year" **as integer values**, then click "Change Date".<br />![instructions4_edit](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions4_edit.jpg)<br />You can see that both clocks dates have been updated.<br />![instructions5](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions5.jpg) |
| 5. Undo a clock creation by clicking "Undo Command" |
| Add a Clock View and then click the "Undo Command" button.<br />![instructions8_edit](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions8_edit.jpg)<br />You can see that the clock creation has been undone. Note: the redo command works the same for the creation of both analog and digital clocks<br />![instructions1](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions1.jpg) |
| 6. Redo a clock creation by clicking "Redo Command" |
| In continuation from example (5), a Clock View creation had been undone.<br />![instructions1](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions1.jpg)<br /> Select "Redo Command".<br />![instructions7.1_edit](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions7.1_edit.jpg)<br />Now you can see that the digital clock we added in example (5) has returned. Note: the redo command works the same for the creation of both analog and digital clocks.<br />![instructions2](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions2.jpg) |
| 7. Undo a time change/date change by clicking "Undo Command" |
| Add a digital clock and change the date.<br />![instructions2](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions8.jpg) <br />The clock was originally set to 11:19 AM. Now it has been set to 12:00 AM. Now select "Undo Command"<br />![instructions9](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions9.2.jpg) <br />You can see that the clock is now back to its original time. Note: the undo command works the same for the date and/or time change of both analog and digital clocks.<br />![instructions8](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions8.jpg). |
| 8. Redo time change/date change by clicking "Redo Command" |
| In continuation from example (7), click the "Redo Command" button.<br />![instructions9_edit](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions9_edit.jpg)<br />You can see that the clock goes back the the time it was changed to before the command was undone. Note: the redo command works the same for the time and/or date change of both analog and digital clocks.<br />![instructions9](C:\Users\Brandon\Desktop\HW2 Images\Photos\instructions9.jpg) |

Note: Undo's and Redo's can be done without bounds. For example, if you create one-hundred clocks, you will be able to undo all of those creations and then redo them. 

---

**Class Architecture and Further Discussion **

This project is broken up into four groups of classes :

1. Model classes
2. Controller classes
3. View classes
4. Command Classes

Additionally there is a main class, which acts as the entry point for the application.



##### Menu_Activity

Menu_Activity acts as a main class for the application. It serves as an entry point for the application, instantiating the additional classes of the project. It also handles user input and the doing and undoing of commands. Lastly, it ticks the clocks and updates the UI through the use of threads.

##### Clock Controller

ClockController is the *controller* piece of the Model, View, Controller design pattern which is implemented in this project. The ClockController is responsible for managing interaction between the ClockAdapter and the ClockModel. Moreover, the ClockController insures concurrency between the different ClockViews which must be updated to the current time value of the ClockModel. The ClockController holds a reference through instance variables to the ClockAdapter and the ClockModel. This allows the Controller the ability to set the ClockModel's date and time value stored in the form of a Java Calendar object. Furthermore, if the ClockModel time is to be displayed through a ClockView, the ClockController will send the ClockAdapter the ClockModel's Java Calendar object. This reinforces separation of concerns. We know that all of the time date displayed via the ClockViews are coming from one place, the ClockModel. Also, we know that if the data isn't getting the to ClockViews, then the controller isn't doing its work. This allows for pinpointing problems in the implementation easier.



##### Clock Model

The clock model is *model* piece of the Model, View, Controller design pattern. The Clock Model is responsible for holding the date related information for the clocks that will be displayed in the UI (user interface) of the application. The Clock Model holds a Java Calendar. Calendar is a class which allows for storing of a specific date and time, while also having underlying logic to handle incrementation of the date and time. This means that a Java Calendar can be at a specific date and time, but can also be incremented to a new date and time without the creation of a new Calendar object. 



##### Clock Adapter

The Clock Adapter is a helper of the *view* piece of the Model, View, Controller design pattern. The clocks of this application are displayed as objects which implement the ClockView interface. Moreover, Clock Adapter helps to provide an on-screen listed view of all the created clocks. This class is extended from an android abstract class called "adapter". This class is attached to a ListView component in the UI which displays the Clock Views. Clock Adapter acts as an adapter for the data which is to be displayed in the list view. Each individual clock is its own view. The Clock Adapter is responsible for creating the views, updating the views, and deleting the views. At a granular level, each clock has specific type associated with it. Clock type one being a digital clock and two being an analog clock. The clock adapter holds an array list of these clock types, which are specified through integer numbers. It contains logic within the getView() method to instantiate an analog clock or digital clock based off the integer value in each array index. Additionally, each Clock View is set to a singular time and date stored in the form of a Java Calendar. This Calendar comes from the ClockController which in turn gets it from the ClockModel. Clock Adapter is not responsible for the logic behind setting a ClockView's time. instead, it is simply responsible for sending a ClockView the new Calendar time which it should be set to.



##### ClockView Interface

The ClockView interface is used to define the necessary methods which a class that implements ClockView interface should contain. The only method defined in the interface is a *setTime* method. It takes in a Java Calendar object as a parameter. This Calendar object is the time in which the ClockView should display. One advantage to having this interface is that the Clock Adapter is able to call *setTime* method on any class which implements ClockView. This reduces the amount of logic that must be present in ClockAdapter to set time for different types of Clock Views. Moreover, it limits the concern of time being set in multiple places within the code base. The logic associated with setting the time for each Clock View is limited to each Clock Views implementation of the method *setTime*().



##### Digital Clock View

Digital Clock view is one of the *views* in the Model, View, Controller design pattern. It is a custom view class extended from Android's RelativeLayout class. The Digital Clock View contains all the necessary functions to inflate the class so that it is viewable within the list view of ClockViews. Moreover, it also contains an implementation of the ClockView interface. Digital Clock View overrides the *getTime()* method of the interface. In the case of Digital Clock View, *getTime()*  simply formats the date from the Java Calendar object and sets a TextView to it. This in turn allows the digital clock to be displayed in the UI.



##### Analog Clock View

Analog Clock view is another one of the *views* in the Model, View, Controller design pattern. It is a custom view class extended from Android's RelativeLayout class. This class is similar to Digital Clock View, but instead of a digital clock made out of a TextView, it displays an analog clock from a custom view library. This class implements the ClockView interface and contains an implementation of the *setTime*() method. The method is responsible for setting the analog clock and the text view which displays the date and seconds of the clock.



##### Command Queue

The Command Queue is a piece of Command design pattern. It is a singleton class which holds two stacks as instance variables, of type Command. The two stacks together makeup the completed commands and undone commands ( as in, if the user undo's a command). When the user wishes to add a clock to the UI or changes the date or time, a command is created to execute this functionality. The Command Queue will put all completed and redone commands into the completed commands stack. All commands undone by the user will go into the undone commands stack. Command Queue manages the commands as they are done, redone, and undone.



##### Command Interface

The Command Queue has two stacks dedicated to holding completed and undone commands. However, these stacks are of type Command. The Command Interface specifies what methods a class which implements Command must have. In the case of Command, a command must be able to be done and undone. Therefore, there are two methods in this interface *do()* and *undo()*. This design allows for there to be commands of all types of nature. Moreover, the Command Queue will be able to manage the commands independent of their functionality, as long as they implement the command interface.



##### CreateClockCommand

The CreateClockCommand is another piece of Command design pattern. The Command Queue keeps track of commands. However, the CreateClockCommand is a command which is responsible for creating a clock in the UI. This command implements the Command Interface and therefore overrides the *do()* and *undo()* methods of the interface. If the user wishes to create an analog or digital clock, the CreateClockCommand will have its do() method invoked. However, if the user wishes to undo the clock they have created, the CreateClockCommands *undo()* method will be invoked. The CreateClockCommand is also responsible for holding any information which is relevant to creating a clock or deleting one. Therefore, it holds the type of clock, analog or digital, that the user wishes to create. Also, the index value stored as an integer. The clock type is relevant to the *do()* method as it describes what clock type to create. However, the index of the ClockView in the ClockAdapter is relevant to the *undo()* method.  This index specifies which Clock View to remove from the ClockAdapter's array of ClockViews.



##### SetClockTimeCommand

The SetClockTimeCommand is another piece of the Command design pattern. It is similar to the CreateClockCommand. It also implements the Command Interface and overrides its methods. However, SetClockTimeCommand is used for when the user wants to change the time and/or date of the ClockModel. The command holds two instance variables repsonsible for the *do()* and *undo()* methods. A newTime variable, of Java Calendar, is used to hold the time in which the user wishes to change the ClockModel to. A perviousTime variable, of Java Calendar, is used to hold the last time at which the ClockModel was at. When *do()* method is called, the ClockController will set the ClockModel to the new Calendar. When *undo()*  method is called, ClockController will set the ClockModel to the previous time and/or date

----





