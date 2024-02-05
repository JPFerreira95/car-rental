# Functional Documentation

This project is inspired in a project of a OOP course that I had, with a little functional adjustments that turns it 
more closely to the *Uber* services.\
The purpose of this application is to simulate the rent of private transportation services to take a customer from a 
point A to a point B.\
In this project, there will be two major entities: the *customer* and the *driver*.
The driver will be able to register one or more vehicles that he owns, and every single vehicle should have their specs
defined, since that might be a key factor for a customer to choose what kind of service he wants.\
The customer will be the one who makes reservations to rent the driver services.
For a rent to be able to exist, the customer will specify their current location (coordinates), their destiny, what kind
of service he wants and then make a reservation. After that, the driver will receive their reservation and choose to 
make the trip or not. \
After the trip completion, there will be a feedback mechanism for each entity to fill, and it will be saved alongside 
with the rest of the trip information.

## 1. Actors of the system

As we know there will be two types of actors in the system that share the same information.
First things first, for a driver and a customer to be able to exist, there will be a user creation mechanism in which 
it is mandatory to write an email and password used for login. Alongside other information to register the user. After 
that there will be an option to choose what kind of user will be created (Customer or Driver) and then it should be filled the
information about that entity.

### 1.1 User creation (shared fields)

The fields used for user creation will be:
 * e-mail
 * password
 * name
 * address
 * date of birth

### 1.2 Customer

The Customer represents the person who makes a reservation. The client will have a specified location (coordinates x and y).
It will also have access to their trip history.\
Added fields:
 * current location (coordinates x and y)
 * rating

### 1.3 Driver

The driver will be the one who takes de reservations. It has a specified location (or initial location) that can be its
starting point (or can be considered its house). And will also have a list of the vehicles he owns.
 * initial location (x and y)
 * current location (x and y)
 * list of vehicles
 * rating
 * dexterity (this will have impact in the quality of the driver and the capacity to endure different weathers)

## 2. Vehicles

This ecosystem contemplates different types os vehicles to rent:
 * Combustion
 * Electric
 * Hybrid

Although the ecosystem should be able to expand in the future for any other vehicles.
Each of the vehicles should have:
 * speed by kilometers
 * price by kilometers
 * current tank liters or kw
 * consumption by kilometers (liters or kw)
 * history of their trips
 * classification from 0 to 100

## 3 Rents/Trips

The process of each rent should have the next steps:
1. The customer should indicate its current coordinates and where he needs to go;
2. The customer chooses what driver/vehicle he wants to rent;
3. The driver may or may not accept the rent;
4. Based on the dexterity of the driver, the weather conditions and possible traffic, it is made an estimate arrival time;
5. The driver stays in the place where the trip ended waiting for a new rent;
6. After the trip, the client and the driver can give a feedback evaluation about each other.
7. The vehicle tank/autonomy should be updated

For the driver to fill the tank, it should open their account and choose the option to fill it.
