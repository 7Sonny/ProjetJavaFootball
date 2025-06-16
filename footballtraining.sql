-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : lun. 16 juin 2025 à 19:17
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `footballtraining10`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `firstname`, `name`, `adresse`, `email`) VALUES
(7, 'Christophe', 'Verra', 'nice', 'zz@zz.fr'),
(8, 'Ambre', 'Verra', 'Nice', 'am.ve@gmail.com'),
(9, 'Claudine ', 'Verra', '185 chemin de la costiere ', 'zz@zz.fr'),
(10, 'nathan ', 'roux', 'nice', 'nrx@gmail.com'),
(11, 'aaa', 'dreg', 'nice', 'aa@aa.fr');

-- --------------------------------------------------------

--
-- Structure de la table `entrainement`
--

CREATE TABLE `entrainement` (
  `id` int(11) NOT NULL,
  `sport` varchar(255) NOT NULL,
  `entraineur` varchar(255) NOT NULL,
  `client` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `entrainement`
--

INSERT INTO `entrainement` (`id`, `sport`, `entraineur`, `client`) VALUES
(1, 'football', '[]', '[]'),
(2, 'football', '[]', '[]'),
(3, 'football', '[verra sonny, verra sonny, verra sonny]', '[sonny verra, jospeh deveze , joseph  deveze]'),
(4, 'football', '[verra sonny, verra sonny, verra sonny, verra sonny, verra sonny, verra sonny, verra sonny]', '[sonny verra, jospeh deveze , joseph  deveze, david david, aymane bagharre]'),
(5, '', '[]', '[]'),
(6, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(7, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(8, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(9, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(10, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(11, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(12, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(13, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(14, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(15, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(16, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(17, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(18, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(19, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(20, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(21, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(22, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]'),
(23, 'football', '[Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie, Sonny Verra, alain becarie]', '[Christophe Verra, Ambre Verra, Claudine  Verra, nathan  roux, aaa dreg]');

-- --------------------------------------------------------

--
-- Structure de la table `entraineur`
--

CREATE TABLE `entraineur` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `entraineur`
--

INSERT INTO `entraineur` (`id`, `firstname`, `name`, `adresse`, `email`) VALUES
(2, 'Verra', 'Sonny', 'nice', 'aa@aa.fr'),
(3, 'becarie', 'alain', 'aa', 'aa@aa.fr');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id` int(11) NOT NULL,
  `nomclient` varchar(255) NOT NULL,
  `nomentraineur` varchar(255) NOT NULL,
  `service` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`id`, `nomclient`, `nomentraineur`, `service`) VALUES
(1, 'sonny verra', 'Cardio', 'verra sonny'),
(2, 'sonny verra', 'Cardio', 'verra sonny'),
(3, 'sonny verra', 'Cardio', 'verra sonny'),
(4, 'sonny verra', 'Cardio', 'verra sonny'),
(5, 'sonny verra', 'Cardio', 'verra sonny'),
(6, 'david david', 'Cardio', 'verra sonny'),
(7, 'Christophe Verra', 'Match', 'Sonny Verra'),
(8, 'Ambre Verra', 'Entrainement', 'Sonny Verra'),
(9, 'Christophe Verra', 'Match', 'Sonny Verra'),
(10, 'Claudine  Verra', 'alain becarie', 'Cardio'),
(11, 'nathan  roux', 'Sonny Verra', 'Match'),
(12, 'aaa dreg', 'Sonny Verra', 'Match'),
(13, 'Ambre Verra', 'Sonny Verra', 'Cardio');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `entrainement`
--
ALTER TABLE `entrainement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `entraineur`
--
ALTER TABLE `entraineur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `entrainement`
--
ALTER TABLE `entrainement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT pour la table `entraineur`
--
ALTER TABLE `entraineur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
