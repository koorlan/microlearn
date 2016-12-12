
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
(1, 'La modularite des ondes dans l espace', '## Partie1 : La succubation de l emmental',0,1),
(2, 'chapter2', 'content2',0,2),
(3, 'chapter3', 'content',0,3),
(4, 'chapter4', 'content',0,4),
(5, 'chapter5', 'content',0,5),
(6, 'chapter6', 'content',0,6),
(7, 'chapter7', 'content',0,7),
(8, 'chapter8', 'content',0,8);

INSERT INTO MCT (id, successcondition, chapter_id)
VALUES 
(1, 2, 1),
(2, 2, 2);

INSERT INTO QUESTION (id, questiontext, mct_id)
VALUES 
(1, 'How are you ?', 1),
(2, 'What is your name ?', 1),
(3, 'How are you ?', 2),
(4, 'What is your name ?', 2),
(5, 'Number of perfect silces for a pizza', 1);

INSERT INTO ANSWER (id, istrue, text, question_id)
VALUES
(1, 1, 'Fine !', 1),
(2, 1, 'Fine !', 3),
(3, 0, 'Not good ...', 1),
(4, 0, 'Not good ...', 3),
(5, 1, 'Anthony', 2),
(6, 1, 'Anthony', 4),
(7, 0, 'Roger', 2),
(8, 0, 'Roger', 4),
(9, 0, '1', 5),
(10, 0, '2', 5),
(11, 0, '3', 5),
(12, 0, '4', 5),
(13, 1, 'We don t care it s a pizza', 5);

INSERT INTO ATTEMPT (id, date, success, mct_id, student_login)
VALUES
(1, NOW(), 1, 1, 'korlans');
