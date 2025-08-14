# T3_FinalSprint

# Gym Management System

## Overview

The Gym Management System is a console-based Java application designed to simulate the operations of a gym. The system supports:
User registration and authentication
Role-based access for Admins, Trainers, and Members
Membership purchasing and tracking
Workout class management
Merchandise inventory
PostgreSQL database integration
Logging via a custom logger
Secure password hashing

---

## Project Structure

Classes/ # Entity classes
DAO/ # Data access for DB interaction
Database/ # DB connection and setup
Loggin/ # Custom logger
Services/ # Business logic services
UI/ # Menu and user interface
Utils/ # Utility classes
Main.java/ # Entry point( where the application is run from)

---

## Features

### Registration & Login

- All users register with name, email, password, role, phone number, and address.
- Passwords can be hashed.
- Role-based login displays unique menus.

### Admin

- View all users with contact info
- Delete users
- Track revenue from memberships
- Manage merchandise (add, set prices, report stock)

### Trainer

- Add, update, delete workout classes
- View assigned classes
- Purchase memberships
- View merchandise

### Member

- View available workout classes
- View membership cost
- Purchase memberships
- View merchandise

---

## Database Schema (PostgreSQL)

### users

Stores all users including Admins, Trainers, and Members.

```sql
id SERIAL PRIMARY KEY,
name VARCHAR(100),
email VARCHAR(100) UNIQUE,
password VARCHAR(255),
role VARCHAR(20),
phone_number VARCHAR(20),
address TEXT
```

### memberships

```sql
id SERIAL PRIMARY KEY,
member_id INT REFERENCES users(id),
type VARCHAR(50),
description TEXT,
cost NUMERIC(10, 2),
start_date DATE DEFAULT CURRENT_DATE,
end_date DATE
```

### workout_classes

```sql
id SERIAL PRIMARY KEY,
name VARCHAR(100),
schedule VARCHAR(100),
trainer_id INT REFERENCES users(id)
```

### gym_merch

```sql
id SERIAL PRIMARY KEY,
name VARCHAR(100),
type VARCHAR(50),
price NUMERIC(10,2),
stock INT
```

## Requirements

- Java 17+
- PostgreSQL 14+
- PostgreSQL JDBC driver

## Setup Instructions

### Step 1: Clone the repository

```bash
git clone https://github.com/aantle11/T3_FinalSprint.git
cd T3_FinalSprint
```

### Step 2: Compile the code

```bash
javac Main.java ui/*.java Classes/*.java DAO/*.java Database/*.java Logging/*.java Services/*.java Utils/*.java
```

### Step 3: Run the app

```bash
java Main
```

### Step 4: PostreSQL setup

- Start PostreSQL
- Create DB and run schema

```bash
psql postgres
CREATE DATABASE gym_management;
\c gym_management
```

- Import tables and data

```bash
  \i 'sample_data_insert.sql'
```

- Or full dump

```bash
\i 'gym_management_dump.sql'
```

---

## Example Usage

=== Gym Management System ===

1. Login
2. Register
3. Exit
   Enter Choice:

- Login as a Admin to manage all data
- Login as a Trainer to manage classes
- Login as a Member to view memberships and to make purchases

## Loggings

All logs are written to:

```bash
Logging/logs.txt
```

this includes

- login attempts
- CRUD operations
- Purchases
- Class enrollements
  Tracks user actions, errors, and key system events.

---

# Class Overview

- User - Contains name, email password, etc
- Admin - extends User; manages users, merchandise, revenue
- Trainer - extends User; manages workout classes
- Member - extends User; enrolls in classes, purchases memberships
- Membership - links to Member; contains type of class, cost, dates
- WorkoutClass - links to Trainer; contains schedule, name
- Merchandise - products with price and stock
- DAO classes - handles database CRUD for each entity
- Services - business logic, validation and data flow

## Team

Alicia Antle & Keira Hancock

---

Alicia Individual Report
My Contributions / Branches I worked on was the classes folder containing all the classes for the system, aswell as the Database folder, the User Service and part of the readme. The challenges I faced during development with this project were making sure that the admin trainer and member classes only had access to the features that they should.
