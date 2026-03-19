INSERT INTO student (name, color) VALUES ('Lucca', '#3498db');
INSERT INTO student (name, color) VALUES ('Lívia', '#3498db');
INSERT INTO student (name, color) VALUES ('Ana', '#3498db');
INSERT INTO student (name, color) VALUES ('Helena', '#3498db');

INSERT INTO student (name, color) VALUES ('Júlia Renata', '#e74c3c');
INSERT INTO student (name, color) VALUES ('Cecília', '#e74c3c');
INSERT INTO student (name, color) VALUES ('Vallentina', '#e74c3c');
INSERT INTO student (name, color) VALUES ('Stefany', '#e74c3c');
INSERT INTO student (name, color) VALUES ('Carlos', '#e74c3c');
INSERT INTO student (name, color) VALUES ('Bernardo', '#e74c3c');

INSERT INTO student (name, color) VALUES ('Júlia de Bem', '#2ecc71');
INSERT INTO student (name, color) VALUES ('Jordana', '#2ecc71');
INSERT INTO student (name, color) VALUES ('Piter', '#2ecc71');
INSERT INTO student (name, color) VALUES ('Felipe Araújo', '#2ecc71');
INSERT INTO student (name, color) VALUES ('Gustavo', '#2ecc71');
INSERT INTO student (name, color) VALUES ('Arthur', '#2ecc71');

INSERT INTO question (statement, answer)
VALUES ('Quanto é 2+2?', '4');
INSERT INTO question (statement, answer)
VALUES ('Quanto é 5+7?', '12');
INSERT INTO question (statement, answer)
VALUES ('Quanto é 9-4?', '5');
INSERT INTO question (statement, answer)
VALUES ('Quanto é 6x3?', '18');
INSERT INTO question (statement, answer)
VALUES ('Quanto é 20/5?', '4');
INSERT INTO question (statement, answer)
VALUES ('Quanto é 15+8?', '23');
INSERT INTO question (statement, answer)
VALUES ('Quanto é 30-17?', '13');
INSERT INTO question (statement, answer)
VALUES ('Quanto é 7x8?', '56');
INSERT INTO question (statement, answer)
VALUES ('Quanto é 81/9?', '9');
INSERT INTO question (statement, answer)
VALUES ( 'Quanto é 14+19?', '33');
INSERT INTO question (statement, answer)
VALUES ( 'Quanto é 50-26?', '24');

INSERT INTO game_config (id, xp_on_correct, xp_on_wrong, damage_min, damage_max, damage_on_wrong, boss_name, boss_max_hp, boss_image_url)
VALUES (1, 10, 0, 5, 15, 0, 'Monstro', 100, 'https://www.dndbeyond.com/avatars/thumbnails/30761/774/1000/1000/638061093283829548.png');