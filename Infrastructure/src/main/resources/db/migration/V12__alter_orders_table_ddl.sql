ALTER TABLE `orders` ADD COLUMN `user_id` INT;
ALTER TABLE `orders` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);