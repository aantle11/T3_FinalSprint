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

## Loggings
 All logs are written to:
```bash
Logging/logs.txt
```
Tracks user actions, errors, and key system events.

---

## Team
Alicia Antle & Keira Hancock

---
