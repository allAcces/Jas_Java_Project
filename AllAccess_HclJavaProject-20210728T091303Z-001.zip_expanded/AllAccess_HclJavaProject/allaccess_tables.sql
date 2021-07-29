CREATE TABLE admin(Email varchar(100) PRIMARY KEY NOT NULL,password varchar(50) NOT NULL,type number);

CREATE TABLE USERS(user_id number PRIMARY KEY NOT NULL,username varchar(100) NOT NULL,user_password varchar(50) NOT NULL,type number,user_address varchar(100) NOT NULL,contact varchar(20) not null,gender varchar(5) not null,profile_photo BLOB);

CREATE TABLE STATES(state_id number PRIMARY KEY NOT NULL,state_name varchar(100) UNIQUE NOT NULL);

CREATE TABLE CITY(City_id number(10) PRIMARY KEY NOT NULL,City_name varchar(50) NOT NULL,state_id number NOT NULL , FOREIGN KEY (state_id) REFERENCES STATE(state_id));

CREATE TABLE PRODUCT(product_id number PRIMARY KEY NOT NULL,product_title varchar(250) NOT NULL,price number(7,2) NOT NULL,product_manufacturing_date date NOT NULL,vat number(7,2) NOT NULL,discount number(7,2) NOT NULL,Stock number NOT NULL);

CREATE TABLE Area(Area_id number(10) PRIMARY KEY NOT NULL,Area_name varchar(50) NOT NULL,city_id number NOT NULL , FOREIGN KEY (city_id) REFERENCES CITY(city_id));

CREATE TABLE Enquiry(Enquiry_id number PRIMARY KEY NOT NULL,Enquiry_msg varchar(250) NOT NULL,Enquiry_msg_date_time date NOT NULL,Enquiry_reply varchar(250) NOT NULL,Enquiry_reply_date_time date NOT NULL);

CREATE TABLE Payment(Payment_id number PRIMARY KEY NOT NULL,Payment_amount number NOT NULL,Payment_date date NOT NULL,Payment_due_date date NOT NULL);
