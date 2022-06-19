-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.24-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table si_bengkel.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `nama_admin` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table si_bengkel.admin: ~6 rows (approximately)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id_admin`, `nama_admin`, `username`, `password`) VALUES
	(1, 'rizky', 'rizky', 'rizky'),
	(2, 'ridho', 'ridho', 'ridho'),
	(3, 'naufal', 'naufal', 'naufal'),
	(4, 'faiz', 'faiz', 'faiz'),
	(5, 'azhar', 'azhar', 'azhar'),
	(6, 'hirdhan', 'hirdhan', 'hirdhan');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table si_bengkel.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `nama_customer` varchar(50) NOT NULL,
  `notelp_customer` varchar(20) NOT NULL,
  PRIMARY KEY (`id_customer`),
  UNIQUE KEY `notelp_customer_unique` (`notelp_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table si_bengkel.customer: ~6 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id_customer`, `nama_customer`, `notelp_customer`) VALUES
	(1, 'satya', '08723456'),
	(3, 'durya', '08212345'),
	(4, 'leli', '082812347'),
	(5, 'reja', '08134567'),
	(6, 'tasya', '083812345'),
	(7, 'mitha', '082122635');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table si_bengkel.detail_perubahan
CREATE TABLE IF NOT EXISTS `detail_perubahan` (
  `keterangan` varchar(255) NOT NULL,
  `data_sebelum` varchar(255) NOT NULL,
  `data_sesudah` varchar(255) NOT NULL,
  `produk_id` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  KEY `fk_produk_id` (`produk_id`),
  KEY `fk_admin_id` (`admin_id`),
  CONSTRAINT `fk_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id_admin`),
  CONSTRAINT `fk_produk_id` FOREIGN KEY (`produk_id`) REFERENCES `produk` (`id_produk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table si_bengkel.detail_perubahan: ~6 rows (approximately)
/*!40000 ALTER TABLE `detail_perubahan` DISABLE KEYS */;
INSERT INTO `detail_perubahan` (`keterangan`, `data_sebelum`, `data_sesudah`, `produk_id`, `admin_id`) VALUES
	('stok', '0', '40', 1, 1),
	('stok', '0', '60', 2, 2),
	('stok', '0', '20', 3, 3),
	('stok', '0', '10', 4, 4),
	('stok', '0', '15', 5, 5),
	('stok', '0', '10', 6, 6);
/*!40000 ALTER TABLE `detail_perubahan` ENABLE KEYS */;

-- Dumping structure for table si_bengkel.detail_transaksi
CREATE TABLE IF NOT EXISTS `detail_transaksi` (
  `jumlah_produk` int(11) NOT NULL,
  `jumlah_harga` int(11) NOT NULL,
  `produkID` int(11) NOT NULL,
  `transaksiID` int(11) NOT NULL,
  KEY `fk_produkID` (`produkID`),
  KEY `fk_transaksiID` (`transaksiID`),
  CONSTRAINT `fk_produkID` FOREIGN KEY (`produkID`) REFERENCES `produk` (`id_produk`),
  CONSTRAINT `fk_transaksiID` FOREIGN KEY (`transaksiID`) REFERENCES `transaksi` (`id_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table si_bengkel.detail_transaksi: ~6 rows (approximately)
/*!40000 ALTER TABLE `detail_transaksi` DISABLE KEYS */;
INSERT INTO `detail_transaksi` (`jumlah_produk`, `jumlah_harga`, `produkID`, `transaksiID`) VALUES
	(1, 80000, 1, 1),
	(1, 80000, 2, 2),
	(1, 200000, 3, 3),
	(1, 220000, 4, 4),
	(1, 600000, 5, 5),
	(1, 200000, 6, 6);
/*!40000 ALTER TABLE `detail_transaksi` ENABLE KEYS */;

-- Dumping structure for table si_bengkel.kasir
CREATE TABLE IF NOT EXISTS `kasir` (
  `id_kasir` int(11) NOT NULL AUTO_INCREMENT,
  `nama_kasir` varchar(50) NOT NULL,
  `notelp_kasir` varchar(20) NOT NULL,
  `alamat_kasir` varchar(100) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id_kasir`),
  UNIQUE KEY `notelp_kasir_unique` (`notelp_kasir`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table si_bengkel.kasir: ~6 rows (approximately)
/*!40000 ALTER TABLE `kasir` DISABLE KEYS */;
INSERT INTO `kasir` (`id_kasir`, `nama_kasir`, `notelp_kasir`, `alamat_kasir`, `username`, `password`) VALUES
	(1, 'safi', '082234567', 'surabaya', 'safi', 'safi'),
	(2, 'herdaya', '081245675', 'surabaya', 'herdaya', 'herdaya'),
	(3, 'hanip', '083813567', 'surabaya', 'hanip', 'hanip'),
	(4, 'firdausiyah', '089235434', 'surabaya', 'firdausiyah', 'firdausiyah'),
	(5, 'sando', '083834567', 'sidoarjo', 'sando', 'sando'),
	(6, 'ricky', '0878456789', 'surabaya', 'ricky', 'ricky');
/*!40000 ALTER TABLE `kasir` ENABLE KEYS */;

-- Dumping structure for table si_bengkel.kategori
CREATE TABLE IF NOT EXISTS `kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(10) NOT NULL,
  PRIMARY KEY (`id_kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table si_bengkel.kategori: ~2 rows (approximately)
/*!40000 ALTER TABLE `kategori` DISABLE KEYS */;
INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
	(1, 'alat'),
	(2, 'jasa');
/*!40000 ALTER TABLE `kategori` ENABLE KEYS */;

-- Dumping structure for table si_bengkel.produk
CREATE TABLE IF NOT EXISTS `produk` (
  `id_produk` int(11) NOT NULL AUTO_INCREMENT,
  `deskripsi_produk` varchar(255) NOT NULL,
  `harga_produk` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `kategoriID` int(11) NOT NULL,
  `supplierID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_produk`),
  KEY `fk_kategoriID` (`kategoriID`),
  KEY `fk_supplierID` (`supplierID`),
  CONSTRAINT `fk_kategoriID` FOREIGN KEY (`kategoriID`) REFERENCES `kategori` (`id_kategori`),
  CONSTRAINT `fk_supplierID` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`id_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table si_bengkel.produk: ~6 rows (approximately)
/*!40000 ALTER TABLE `produk` DISABLE KEYS */;
INSERT INTO `produk` (`id_produk`, `deskripsi_produk`, `harga_produk`, `stok`, `kategoriID`, `supplierID`) VALUES
	(1, 'yamalube 1lt', 80000, 40, 1, 1),
	(2, 'unioil 1lt', 80000, 60, 1, 2),
	(3, 'bridgestone 1 set', 200000, 20, 1, 3),
	(4, 'michellin', 220000, 10, 1, 4),
	(5, 'GS Astra Mobil', 600000, 15, 1, 5),
	(6, 'GS Astra Motor', 200000, 10, 1, 6);
/*!40000 ALTER TABLE `produk` ENABLE KEYS */;

-- Dumping structure for table si_bengkel.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id_supplier` int(11) NOT NULL AUTO_INCREMENT,
  `nama_supplier` varchar(50) NOT NULL,
  `notelp_supplier` varchar(20) NOT NULL,
  `alamat_supplier` varchar(100) NOT NULL,
  PRIMARY KEY (`id_supplier`),
  UNIQUE KEY `notelp_supplier_unique` (`notelp_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table si_bengkel.supplier: ~6 rows (approximately)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`id_supplier`, `nama_supplier`, `notelp_supplier`, `alamat_supplier`) VALUES
	(1, 'widy', '0814567890', 'surabaya'),
	(2, 'fayi', '0828374647', 'sidoarjo'),
	(3, 'ilyas', '0895621531', 'malang'),
	(4, 'alan', '08146273', 'sidoarjo'),
	(5, 'alfa', '0823674564', 'gresik'),
	(6, 'rehan', '08126734243', 'surabaya');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

-- Dumping structure for table si_bengkel.transaksi
CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `tgl_transaksi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `total_harga` int(11) NOT NULL,
  `customerID` int(11) NOT NULL,
  `kasirID` int(11) NOT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `fk_customerID` (`customerID`),
  KEY `fk_kasirID` (`kasirID`),
  CONSTRAINT `fk_customerID` FOREIGN KEY (`customerID`) REFERENCES `customer` (`id_customer`),
  CONSTRAINT `fk_kasirID` FOREIGN KEY (`kasirID`) REFERENCES `kasir` (`id_kasir`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table si_bengkel.transaksi: ~6 rows (approximately)
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
INSERT INTO `transaksi` (`id_transaksi`, `tgl_transaksi`, `total_harga`, `customerID`, `kasirID`) VALUES
	(1, '2022-05-25 17:00:00', 80000, 1, 1),
	(2, '2022-05-25 18:55:18', 80000, 7, 2),
	(3, '2022-05-25 18:49:01', 200000, 3, 3),
	(4, '2022-05-25 18:49:01', 220000, 4, 4),
	(5, '2022-05-25 18:49:01', 600000, 5, 5),
	(6, '2022-05-25 18:49:01', 200000, 6, 6);
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
