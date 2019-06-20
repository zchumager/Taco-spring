-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 20, 2019 at 04:36 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `taco_spring`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('bob', 'ROLE_USER'),
('sara', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `ingredients`
--

CREATE TABLE `ingredients` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ingredients`
--

INSERT INTO `ingredients` (`id`, `name`, `type`) VALUES
('FLTO', 'Flour Tortilla', 0),
('COTO', 'Corn Tortilla', 0),
('GRBF', 'Ground Beef', 1),
('CARN', 'Carnitas', 1),
('TMTO', 'Diced Tomatoes', 2),
('LETC', 'Lettuce', 2),
('CHED', 'Cheddar', 3),
('JACK', 'Monterrey Jack', 3),
('SLSA', 'Salsa', 4),
('SRCR', 'Sour Cream', 4);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `cccvv` varchar(255) DEFAULT NULL,
  `cc_expiration` varchar(255) DEFAULT NULL,
  `cc_number` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tacos`
--

CREATE TABLE `tacos` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tacos_ingredients`
--

CREATE TABLE `tacos_ingredients` (
  `tacos_id` int(11) NOT NULL,
  `ingredients_id` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('bob', '$2a$10$/ns.CwZ9sdhQaVjw/bwBQeelnmTZTI19trLtyY/bjbIVUokAckX8y', 1),
('sara', '$2a$10$WPDbKLCRnV0UrkEs2IEtUejsZiicxt0/GhUcOkg2.UscjBi8tOmxa', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD KEY `fk_authorities_users` (`username`);

--
-- Indexes for table `ingredients`
--
ALTER TABLE `ingredients`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tacos`
--
ALTER TABLE `tacos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tacos_ingredients`
--
ALTER TABLE `tacos_ingredients`
  ADD KEY `FK6n5myefe5n7w60nylbxs5dn4x` (`ingredients_id`),
  ADD KEY `FK8bas0lim5pkbeyvypqf7qa6a2` (`tacos_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`);
