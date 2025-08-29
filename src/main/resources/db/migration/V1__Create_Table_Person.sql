DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `sobrenome` varchar(80) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `genero` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
);

