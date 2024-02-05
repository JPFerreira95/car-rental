# Functional Documentation

This project is inspired in a project of a OOP course that I had, with a little functional adjustments that turns it 
more closely to the *Uber* services.\
The purpose of this application is to simulate the rent of private transportation services to take a customer from a 
point A to a point B.\
In this project, there will be two major entities: the *customer* the *driver*.
The driver will be able to register one or more vehicles that he owns, and every single vehicle should have their specs
defined, since that might be a key factor for a customer to choose what kind of service he wants.\
The customer will be the one who makes reservations to rent the driver services.
For a rent to be able to exist, the customer will specify their current location (coordinates), their destiny, what kind
of service he wants and then make a reservation. After that, the driver will receive their reservation and choose to 
make the trip or not. \
After the trip completion, there will be a feedback mechanism for each entity to fill, and it will be saved alongside 
with the rest of the trip information.

## 1. Users

First things first, for a driver and a customer to be able to exist, there will be a user creation mechanism in which 
it is mandatory to write an email and password for login alongside other information to register the user. After that 
there will be an option to choose what kind of user will be created (Customer or Driver) and then it should be filled the
information about that entity.

### 1.1 User creation

The fields used for user creation will be:
 * e-mail
 * password
 * name
 * address
 * date of birth

