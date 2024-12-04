INSERT INTO `users` VALUES (1,'ramesh@gmail.com','$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em');
INSERT INTO `users` VALUES (2,'admin@gmail.com','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu');
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN');
INSERT INTO `roles` VALUES (2,'ROLE_USER');
INSERT INTO `users_roles` VALUES (2,1);
INSERT INTO `users_roles` VALUES (1,2);
INSERT INTO `metric` (id,click, city, region, country, time_zone) VALUES (1,0, 'São Paulo', 'SP', 'Brazil', 'America/Sao_Paulo');