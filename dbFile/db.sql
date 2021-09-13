USE `demoapp`;
DELETE FROM demoapp.user where Name = 'Demo User';
INSERT INTO demoapp.user VALUES (3,'Demo User','demouser@healthcare.com','test');
select * from demoapp.user;
