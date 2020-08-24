
/* Insert main users into the database. Demo's password is "ClinicAppDemo", and User's password is "ClinicAppUser" */
insert into clinic_user values (1, '$2a$10$.yPe0ubG3v63GY2q7/5FhOapyX.pjM4v1qnoBToir809Ux76kXcTi', 'Demo');
insert into clinic_user values (2, '$2a$10$LPPZMGgBWjYtWu9XZR/.vO0aOZTY/lDOePPJVbt/CQaU8QQaiU2Yi', 'User');

insert into role values (1, 'ROLE_ADMIN');
insert into role values (2, 'ROLE_USER');

insert into clinic_user_roles values (1, 1);
insert into clinic_user_roles values (1, 2);
insert into clinic_user_roles values (2, 2);

insert into patient values (1, 'Canada', '1997-02-27', 'foreigncode@gmail.com', 'Mustafa' ,0, 'Abdulmajeed', '', '613-415-1052');
insert into patient values (2, 'United States', '1992-05-13', 'someuser@gmail.com', 'John' ,0, 'Smith', '', '555-232-3133');
insert into patient values (3, 'Algeria', '1995-10-30', 'spoopy@hotmail.com', 'Jane' ,1, 'Doe', '', '555-103-9382');

INSERT INTO VISIT VALUES (1, '2020-08-10', 'Patient complained about nose sizes. The patient would like a smaller nose.',7,1); 
INSERT INTO VISIT VALUES (2, '2020-08-11', 'Patient is coming back for a follow up to check out the surgery results. ',29,1); 
INSERT INTO VISIT VALUES (3, '2020-08-15', 'Patient is coming back for a follow up to make sure the nose healed ',29,1); 


insert into visit values (4, '2020-05-05', 'Patient came in with concerns about oversized breasts, and would like a reduction surgery.', 15, 3);
insert into visit values (5, '2020-05-21', 'Post-surgery recovery follow-up', 29, 3);

insert into visit_photos values (1, '/patient_images/patients/1/visit/1/image1.png');
insert into visit_photos values (1, '/patient_images/patients/1/visit/1/image2.png');
insert into visit_photos values (1, '/patient_images/patients/1/visit/1/image3.png');
insert into visit_photos values (2, '/patient_images/patients/1/visit/2/image1.png');
insert into visit_photos values (2, '/patient_images/patients/1/visit/2/image2.png');
insert into visit_photos values (3, '/patient_images/patients/1/visit/3/image1.png');

insert into visit_photos values (4, '/patient_images/patients/3/visit/4/image1.png');
insert into visit_photos values (4, '/patient_images/patients/3/visit/4/image2.png');
insert into visit_photos values (5, '/patient_images/patients/3/visit/5/image1.png');
insert into visit_photos values (5, '/patient_images/patients/3/visit/5/image2.png');
