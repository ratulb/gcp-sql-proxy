SET PASSWORD FOR 'root'@'localhost' = PASSWORD('password');
FLUSH PRIVILEGES;

CREATE USER 'gcp-sql-proxy'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'gcp-sql-proxy'@'localhost';

