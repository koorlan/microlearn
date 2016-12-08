
INSERT INTO ACCOUNT ( type,login, password,firstname, lastname) 
VALUES 
('TEACHER','korlant','f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9','korlan','colas'),
('TEACHER','korlan2t','f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9','korlan','colas'),
('STUDENT','korlans','f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9','korlan','colas');

INSERT INTO MODULE (id, title, content, teacher_login) 
VALUES 
(0, 'Module0', 'content0','korlant'),
(1, 'Module1', 'content1','korlant'),
(2, 'Module2', 'content2','korlant'),
(3, 'Module3', 'content3', 'korlan2t'),
(4, 'Module4', 'content4', 'korlan2t'),
(5, 'Module5', 'content5', 'korlan2t'),
(6, 'Module6', 'content6', 'korlan2t'),
(7, 'Module7', 'content7', 'korlan2t');

INSERT INTO CHAPTER (id, title, content, module_id) 
VALUES (0, 'chapter0', 'content0', 0),
(1, 'chapter1', 'content1',0),
(2, 'chapter2', 'content2',1);