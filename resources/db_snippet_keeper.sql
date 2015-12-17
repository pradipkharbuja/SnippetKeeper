INSERT INTO `user` (`userId`, `email`, `enabled`, `fullName`, `password`, `role`, `username`) VALUES (1, 'admin@gmail.com', 1, 'Super Admin', 'admin', 'ROLE_ADMIN', 'admin');

INSERT INTO `db_snippet_keeper`.`Language` (`langName`, `additionalInfo`) VALUES ('java', 'java'), ('xml', 'xml');

INSERT INTO `db_snippet_keeper`.`Category` (`categoryId`, `categoryName`, `userId`) VALUES (NULL, 'web.xml', '1'), (NULL, 'security config', '1');

INSERT INTO `db_snippet_keeper`.`User` (`userId`, `email`, `enabled`, `fullName`, `password`, `role`, `username`) VALUES (NULL, 'bidhutkarki@gmail.com', '1', 'Bidhut Karki', 'kabindra', 'ROLE_USER', 'bidhutkarki');