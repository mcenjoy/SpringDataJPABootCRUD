-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Фев 05 2020 г., 21:46
-- Версия сервера: 10.3.16-MariaDB

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `persondemodb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `person`
--

CREATE TABLE `person` (
  `Id` bigint(5) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `person`
--

INSERT INTO `person` (`Id`, `name`, `email`, `country`) VALUES
(1, 'mc', 'mcd', 'USA'),
(3, 'ds', 'ds', 'Norway'),
(5, 'nm', 'mjl', 'US'),
(8, 'New', 'REST', 'China'),
(9, 'cmdm', 'cqwcew', 'Brazil');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `person`
--
ALTER TABLE `person`
  MODIFY `Id` bigint(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
