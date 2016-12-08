
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

INSERT INTO CHAPTER (id, title, content, module_id,position) 
VALUES
(1, 'La modularite des ondes dans l espace', 
'## Partie1 : La succubation de l emmental'
,0,2),
(2, 'chapter2', 'content2',1,1),
(5, 'chapter5', 'content',0,3),
(4, 'chapter4', 'content',0,4),
(3, 'chapter3', 'content',0,5),
(6, 'chapter6', 'content',0,6),
(7, 'chapter7', 'content',0,7),
(8, 'chapter8', 'content',0,8);
(2, 'chapter2', 'content2',1,1);

INSERT INTO MCT (id, successcondition, chapter_id)
VALUES 
(1, 2, 1),
(2, 2, 2);

INSERT INTO QUESTION (id, questiontext, mct_id)
VALUES 
(1, 'How are you ?', 1),
(2, 'What is your name ?', 1),
(3, 'How are you ?', 2),
(4, 'What is your name ?', 2);

INSERT INTO QUESTION_BADANSWERS (question_id, badanswers)
VALUES 
(1, 'I am bad'),
(2, 'Roger'),
(3, 'I am bad'),
(4, 'Roger');

INSERT INTO QUESTION_GOODANSWERS (question_id, goodanswers)
VALUES 
(1, 'I am good'),
(2, 'Anthony'),
(3, 'I am good'),
(4, 'Anthony');

INSERT INTO ATTEMPT (id, date, success, mct_id, student_login)
VALUES
(1, NOW(), 1, 1, 'korlans');
