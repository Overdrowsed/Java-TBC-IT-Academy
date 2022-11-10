connect 'jdbc:derby://localhost:1527/service_aDB;create=true';

CREATE TABLE users (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  surname VARCHAR(255),
  personal_id CHAR(11) UNIQUE,
  balance DECIMAL(31,2)
);

CREATE TABLE agents (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE agent_access (
  row_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  allowed_ip VARCHAR(255),
  agent_id INT,
  FOREIGN KEY (agent_id) REFERENCES agents(id)
);

CREATE TABLE transactions (
  sys_tran_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  agent_id INT,
  FOREIGN KEY (agent_id) REFERENCES agents(id),
  agent_tran_id VARCHAR(255),
  UNIQUE (agent_id, agent_tran_id),
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id),
  amount DECIMAL(31,2),
  date TIMESTAMP
);



INSERT INTO agents (id, name, password) VALUES (1, 'agent-1', 'password1');

INSERT INTO agents (id, name, password) VALUES (2, 'agent-2', 'password2');




INSERT INTO users (id, name, surname, personal_id, balance) VALUES (1, 'Felix', 'Kjellberg', '01006020144', 0);

INSERT INTO users (id, name, surname, personal_id, balance) VALUES (2, 'Mark', 'Fischbach', '01003010654', 0);

INSERT INTO users (id, name, surname, personal_id, balance) VALUES (3, 'Sean', 'McLaughlin', '01041070255', 0);




INSERT INTO agent_access (allowed_ip, agent_id) VALUES ('127.0.0.1', 1);

INSERT INTO agent_access (allowed_ip, agent_id) VALUES ('127.0.0.1', 2);