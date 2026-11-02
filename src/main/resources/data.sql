DELETE FROM patient;

INSERT INTO patient (name, birth_date, email, createda_at, bloodgroup_type)
VALUES
  ('Aarav Sharma', '1990-05-10', 'aarav.sharma@example.com', now(), 'O_POSITIVE'),
  ('Diya Patel', '1995-08-20', 'diya.patel@example.com', now(), 'A_POSITIVE'),
  ('Dishant Verma', '1988-03-15', 'dishant.verma@example.com', now(), 'A_POSITIVE'),
  ('Neha Iyer', '1992-12-01', 'neha.iyer@example.com', now(), 'AB_POSITIVE'),
  ('Kabir Singh', '1993-07-11', 'kabir.singh@example.com', now(), 'O_POSITIVE');
  
  
  
  INSERT INTO doctor (name, specialzation, email)
VALUES
    ('Dr. Rakesh Mehta', 'Cardiology', 'rakesh.mehta@example.com'),
    ('Dr. Sneha Kapoor', 'Dermatology', 'sneha.kapoor@example.com'),
    ('Dr. Arjun Nair', 'Orthopedics', 'arjun.nair@example.com');

