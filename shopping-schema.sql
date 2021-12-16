DROP TABLE IF EXISTS `Shopping List` CASCADE;

CREATE TABLE `Shopping List` (
	`item_id` INTEGER PRIMARY KEY AUTO_INCREMENT,
	`item_name` VARCHAR(255) NOT NULL,
	`item_price` DOUBLE NOT NULL, 
	`aisle_number` INTEGER NOT NULL
);