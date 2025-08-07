-- Sample Data Insert Script for gym_management database

INSERT INTO users (name, email, password, role, phone_number, address) VALUES
('Alice Admin', 'alice@gym.com', 'hashedpassword1', 'Admin', '555-0001', '100 Admin Blvd'),
('Tom Trainer', 'tom@gym.com', 'hashedpassword2', 'Trainer', '555-0002', '200 Trainer St'),
('Megan Member', 'megan@gym.com', 'hashedpassword3', 'Member', '555-0003', '300 Member Rd');


INSERT INTO memberships (member_id, type, start_date, end_date, cost) VALUES
(3, 'Monthly', '2025-08-01', '2025-08-31', 49.99),
(2, 'Annual', '2025-01-01', '2025-12-31', 499.99);


INSERT INTO workout_classes (name, schedule, trainer_name) VALUES
('HIIT', 'Mondays 7AM', 'Tom Trainer'),
('Yoga Flow', 'Wednesdays 6PM', 'Tom Trainer');


INSERT INTO gym_merch (name, type, price, stock) VALUES
('Protein Bar', 'Snack', 2.99, 100),
('Shaker Bottle', 'Gear', 9.99, 50),
('Yoga Mat', 'Gear', 19.99, 30),
('Electrolyte Drink', 'Drink', 3.49, 75);

