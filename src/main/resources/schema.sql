CREATE TABLE IF NOT EXISTS Organization
(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  version INTEGER NOT NULL,
  org_name VARCHAR(30) not null,
  full_name VARCHAR(100) not null,
  inn VARCHAR(12) not null,
  kpp VARCHAR(12) not null,
  address VARCHAR(255) not null,
  phone VARCHAR(20) not null,
  is_active BOOLEAN not null
);

CREATE TABLE IF NOT EXISTS Office
(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  version INTEGER NOT NULL,
  office_name VARCHAR(30) not null,
  address VARCHAR(255) not null,
  phone VARCHAR(255) not null,
  is_active BOOLEAN not null,
  org_id INTEGER not null
);

CREATE INDEX IX_Office_Org_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);

CREATE TABLE IF NOT EXISTS Citizenship
(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  citizenship_code SMALLINT not null,
  citizenship_name VARCHAR(60) not null,
  UNIQUE KEY citizenship_code_UNIQUE (citizenship_code)
);

CREATE TABLE IF NOT EXISTS Doc_Type
(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  doc_code SMALLINT,
  doc_name VARCHAR(255) not null,
  UNIQUE KEY doc_code_UNIQUE (doc_code)
);

CREATE TABLE IF NOT EXISTS Document
(
  id INTEGER PRIMARY KEY,
  version    INTEGER NOT NULL,
  doc_number VARCHAR(20) NOT NULL,
  doc_date DATE not null,
  doc_type_id INTEGER not null
);

CREATE INDEX IX_Document_Doc_Type_Id ON Document (doc_type_id);
ALTER TABLE Document ADD FOREIGN KEY (doc_type_id) REFERENCES Doc_Type(id);


CREATE TABLE IF NOT EXISTS User
(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  version    INTEGER NOT NULL,
  first_name VARCHAR(30) not null,
  second_name VARCHAR(30) not null,
  middle_name VARCHAR(30) not null,
  position_in_company VARCHAR(40) not null,
  phone VARCHAR(20) not null,
  is_identified BOOLEAN not null,
  office_id INTEGER not null,
  citizenship_id INTEGER not null
);

CREATE INDEX IX_User_Office_Id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_User_Citizenship_Id ON User (citizenship_id);
ALTER TABLE User ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship(id);

ALTER TABLE Document ADD FOREIGN KEY (id) REFERENCES User(id);