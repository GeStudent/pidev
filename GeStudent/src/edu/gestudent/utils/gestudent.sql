-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 12 fév. 2020 à 18:27
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestudent`
--

-- --------------------------------------------------------

--
-- Structure de la table `behaviour`
--

DROP TABLE IF EXISTS `behaviour`;
CREATE TABLE IF NOT EXISTS `behaviour` (
  `idbeh` int(11) NOT NULL AUTO_INCREMENT,
  `attendance` int(11) NOT NULL,
  `award` int(11) NOT NULL,
  PRIMARY KEY (`idbeh`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `behaviour`
--

INSERT INTO `behaviour` (`idbeh`, `attendance`, `award`) VALUES
(5, 3, 2);

-- --------------------------------------------------------

--
-- Structure de la table `exams`
--

DROP TABLE IF EXISTS `exams`;
CREATE TABLE IF NOT EXISTS `exams` (
  `idexa` int(11) NOT NULL AUTO_INCREMENT,
  `nomex` varchar(255) NOT NULL,
  `dateex` date NOT NULL,
  `duree` int(11) NOT NULL,
  PRIMARY KEY (`idexa`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;






-- structure de la classe Club
DROP TABLE IF EXISTS `club`;
CREATE TABLE IF NOT EXISTS `club` (
  `id_club` int(30) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `email` varchar(30) NOT NULL,
  `numero` int(30) NOT NULL,
  `description` varchar(100) NOT NULL,
  `etat` int(10) NOT NULL,
  `id_president` int(30) NOT NULL,
  PRIMARY KEY (`id_club`),
  UNIQUE KEY `nom` (`nom`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;





-- structure de la classe evenement
DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id_event` int(30) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `description` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `place` varchar(30) NOT NULL,
  `id_club` int(30) NOT NULL,
  PRIMARY KEY (`id_event`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;



-- structure de la classe MembreClub
DROP TABLE IF EXISTS `membreclub`;
CREATE TABLE IF NOT EXISTS `membreclub` (
  `id_club` int(30) NOT NULL,
  `id_etudiant` int(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`Role`) VALUES
('adminstrator'),
('parent'),
('student'),
('teacher');


-- --------------------------------------------------------

--
-- Structure de la table `seq_user`
--

DROP TABLE IF EXISTS `seq_user`;
CREATE TABLE IF NOT EXISTS `seq_user` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=MyISAM;

--
-- Déchargement des données de la table `seq_user`
--

INSERT INTO `seq_user` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(4234, 1, 9223372036854775806, 1234, 3, 1000, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) DEFAULT NULL,
  `username_canonical` varchar(180) DEFAULT NULL,
  `lastname` varchar(180) DEFAULT NULL,
  `firstname` varchar(180) DEFAULT NULL,
  `image` varchar(180) DEFAULT NULL,
  `email` varchar(180) DEFAULT NULL,
  `email_canonical` varchar(180) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 0,
  `salt` varchar(180) DEFAULT NULL,
  `password` varchar(180) DEFAULT NULL,
  `last_login` date DEFAULT NULL,
  `confirmation_token` varchar(180) DEFAULT NULL,
  `password_requested_at` date DEFAULT NULL,
  `roles` longtext DEFAULT NULL,
  `birthDay` date DEFAULT NULL,
  `phone` int(8) DEFAULT NULL,
  `pays` varchar(180) DEFAULT NULL,
  `adress` varchar(180) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `iclass` int(50) DEFAULT NULL,
  `idcode` varchar(180) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `idcode` (`idcode`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;


--
-- Structure de la table `emprunt`
--

DROP TABLE IF EXISTS `emprunt`;
CREATE TABLE IF NOT EXISTS `emprunt` (
  `id_emprunt` int(11) NOT NULL AUTO_INCREMENT,
  `date_emprunt` date NOT NULL,
  `date_retour` date NOT NULL,
  `id` int(11) NOT NULL,
  `id_livre` int(11) NOT NULL,
  PRIMARY KEY (`id_emprunt`),
  KEY `fk_idL` (`id_livre`),
  KEY `fk_idU` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


--
-- Structure de la table `livres`
--

DROP TABLE IF EXISTS `livres`;
CREATE TABLE IF NOT EXISTS `livres` (
  `id_livre` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `image` varchar(30) NOT NULL,
  `author` varchar(30) NOT NULL,
  `url` varchar(30) NOT NULL,
  `categorie` varchar(30) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id_livre`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livres`
--

INSERT INTO `livres` (`id_livre`, `name`, `image`, `author`, `url`, `categorie`, `quantite`) VALUES
(2, 'jouha', '/image', 'pipo', '/url', 'comic', 25);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
