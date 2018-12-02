# Project: Airline Reservation System

Elijah Luckey

## Objectives

By completing htis project you  will gain experience with the following:
- JavaFX (GUI)
- File I/O
- Exception handling
- `ArrayList` and 2D array
- Using `Scanner` for console input
- Defining classes
- Defining methods
- Loops
- Conditions

## Project Description

I this project, youwill develop a JavaFX application for an Airline Reservation System. The airline manages the information of several floghts. The informtaion of each flight consists of the following:
- flight number
- flight date
- depature time
- arrivale time
- departure city
- destination city
- number of available seats

The passenger seat reservation information consists of the following:
- passenger ID number (Driver License ID, passport, or ID)
- passenger nname
- seat number
- flight number

A file named `flights.txt` contains the information of all flights of the airline. The file is stored in the format shown below.

### Figure 1: Contents of `flight.txt`

```
Flight# FDate   DTime   ATime   DepartCity  DestCity    AvailableSeats
AA1150  20Dec15 23:00   02:00   FORT WAYNE  ORLANDO     70
AA1230  5Nov15  11:30   14:00   BLACKSBURG  BOCA RATON  25
AA1140  4Jan15  07:00   1s1:00   SEATTEL     PHONEIX     42 
```

Another file name `reservations.txt` contains the information of all passengers reservation. The file is stored in the format shown below.

### Figure 2: contents of `reservations.txt`

```
ID              Name            SeatNumber  Flight#
1035093287      George Eric     2A          AA1230
E8742784        Tom Ed          1C          AA1140
1035027864      Sara Shafer     4E          AA1140 
```

## Phase A

When the application is started, it should display a `Main Menu` with seven items, as shown below.

### Table 1: `Main Menu` items and descriptions

- `add a new flight`
    - Ask the user to enter data for a new flight
    - Create new text file that contains the passengers' seats maps as described in Phase B. Name the file to be the fileght number.
    - Add flight information to the `flights.txt` file.
- `make a new reservation`
    - ask the user for the flight number in which the seat is to be reserved
    - ask the user for new passenger ID and name
    - displat passengers seats maps as described in Phase B
    - Ask the user to enter seat number (e.g. 2A, 1C, 4D, ... etc)
    - update the number of available seats in this flight
    - Add passengers reservation information to the `reservation.txt` file
    - update passengers' seats map for this flightin the text file which has file number as file name
- `display passengers seats map`:
    - display the seat pattern for a given flight number
- `list all flights`:
    - display information of all flights
- `list all passenger reservation for all flights`: 
    - display information of all passenger reservation for all flights
- `list all passenger reservation fot a specific flight`:
    - display information of all passenger reservation for a given flight number
- `exit`:
    - exit the program

## Phase B

In this project, you should assign passengers seats ina n airplane. Assume a small aitplane seat numberuig as follows:

### Figure 3: Initial passengers' seats in an airplane

```
1   A B     C D E   F G
2   A B     C D E   F G
3   A B     C D E   F G
4   A B     C D E   F G
5   A B     C D E   F G
6   A B     C D E   F G
7   A B     C D E   F G
8   A B     C D E   F G
9   A B     C D E   F G
10  A B     C D E   F G
```

The program should display the seat patern with a `X` marking the seats already assigned. For example, after `1A`, `2B` and `4C` are taken, the display should look like:

### Figure 4: Update passengers' seats in an airplane

```
1   X B     C D E   F G
2   A X     C D E   F G
3   A B     C D E   F G
4   A B     X D E   F G
5   A B     C D E   F G
6   A B     C D E   F G
7   A B     C D E   F G
8   A B     C D E   F G
9   A B     C D E   F G
10  A B     C D E   F G
```

## Analysis and Design

- you have to use JavaFX to design and create the GUI for the application. We will leave the GUI design of the application to you.
- you have to use object-oriented concepts, i.e classes and methods. We will leave the design of the application to you.
- your application starts by reading the data from two text files
    - `flight.txt` and `reservation.txt`
    - data in `flights.txt` should be stored in an `ArrayList` of flight objects. 
    - data in `reservation.txt` should be stored in an `ArrayList` of passenger objects
- in menu item `add a new flight` 
    - you should create a text file that contains the airplane sets as shown in Figrue 3. 
    - the name of the file file should be the flight number
- in menu item `make a new reservation` 
    - you should display the seats available
    - ask the user to enter the seat desired
    - the user can type in a seat
    - then the display of available seats should be updated as shown in Figure 4
- if the user types in a seat that is already assigned, the application should say that the selected seat is occupied and ask for another choice.
- when the program reads data from other text files that contain the seats maps, the data for each seats map should be stored in 2D array of `char` objects of size `10*8`
- program nust detet all errors and invalid exceptions
- you should always return to the menu after completing any operation. the application should not exit until the user chooses the `Exit` option.

## Grading Policy

- *Activity*:                      *Weight*
- Algorithm:                        20pts
- Use of object oriented concepts:  25pts
- Running program:                  40pts
- Style:                            10pts
- Documentation:                    5pts
- **Total**:                      **100pts**

## Submission Instructions

Zip up your project folder and upload the zip file to Canvas no later than the due date. In the main class, write the names of all team members as a comment. Only one member of the team can submit the project on Canvas.
