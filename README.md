# SER322 Group Project - Parcel Service

---

## Application Domain: 

#### Packages handled within Arizona by the SER322 parcel service.

## Description:
#### The purpose of this database is to store all shipping information to be queried by different types of users for tracking and

## Requirements:
#### - Each parcel should have various attributes associated with it such as weight, dimensions, and tracking number.
#### - Must update package status in real time for tracking purposes.
#### - Location, vehicle, estimated delivery time, etc.
#### - Users must be able to login with credentials.
#### - Users can view a history of parcels they have been associated with (sent/received).
#### - Parcels may be sent in an envelope or a box.
#### - Users can store their preferred address and contact information.


## How to run
---
* Load ```console.sql``` into MySQL for Database - found in ```sql-data``` folder
* Load ``console_1.sql`` into MySQL for initial Database data - found in ```sql-data``` folder
* Use ```gradle run -Pconnection="CONNECTIONNAME" -Puser="USERNAME" -Ppass="PASSWORD" -Pdriver="DRIVER"```

---

### Gradle args
---
* ```CONNECTIONNAME``` is the connection to your data base ex: ``jdbc:mysql://localhost:3306/parcel``
* ```USERNAME``` is your username for MySQL, ex: ```root```
* ```PASSWORD``` is your password for MySQL, ex: ```password```
* ```DRIVER``` is your jdbc driver, ex: ```com.mysql.cj.jdbc.Driver```

---

## How to use
---
* Users may create a new account upon running the program
  * Doing this requires that a user enter a ``First name``, ``Last name``, ``Phone number``, ``Email``, and ``password`` - all to be added to the data base    
* Users may choose to login to an existing account that they have created or one that is already provided in the ``console_1.sql`` file.
  * Example: Email = ```luisR@gmail.com``` , Password = ```pass``` 
* From here a user has 4 options
  * ### Your Packages
    * Here a user can view all of the packages that are in relation to them
  * ### Track Package
    * Here a user can enter their tracking number for a package to find out its information
  * ### Send Package
    * Here a user can select to send a package by entering the package type
    * A package can be either a ``Box`` or a ``Card``
    * The user will also enter the dimensions of the box Ex: ``5x5x1``
    * The user can also enter the weight of the package
    * The user can select the shipping speed either ``Slow`` or ``Fast``
    * The user can select enter where the package is shipping from
    * The user also needs to enter the ``First name``, ``Last name``, ``Email``, ``Phone number``, and ``Ships to`` address of the receiver.
    * Once these fields are filled out A user can select ```Print Shipping Label``` and a file will be generated for you with a shipping label.
  * ### Your Account
    * This displays all of your account information

