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

-- Data exporting was unselected.

-- Dumping structure for table si_bengkel.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `nama_customer` varchar(50) NOT NULL,
  `notelp_customer` varchar(20) NOT NULL,
  PRIMARY KEY (`id_customer`),
  UNIQUE KEY `notelp_customer_unique` (`notelp_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

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

-- Data exporting was unselected.

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

-- Data exporting was unselected.

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

-- Data exporting was unselected.

-- Dumping structure for table si_bengkel.kategori
CREATE TABLE IF NOT EXISTS `kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(10) NOT NULL,
  PRIMARY KEY (`id_kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

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

-- Data exporting was unselected.

-- Dumping structure for table si_bengkel.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id_supplier` int(11) NOT NULL AUTO_INCREMENT,
  `nama_supplier` varchar(50) NOT NULL,
  `notelp_supplier` varchar(20) NOT NULL,
  `alamat_supplier` varchar(100) NOT NULL,
  PRIMARY KEY (`id_supplier`),
  UNIQUE KEY `notelp_supplier_unique` (`notelp_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

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

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
