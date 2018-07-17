DELIMITER $$
	CREATE TRIGGER create_invetario AFTER INSERT ON producto FOR EACH ROW
	BEGIN
		INSERT INTO inventario(id_producto, cantidad, estatus) VALUES(NEW.id_producto, 0, 1);
	END
$$

DELIMITER $$
	CREATE TRIGGER drop_invetario AFTER DELETE ON producto FOR EACH ROW
	BEGIN
		DELETE FROM inventario WHERE id_producto = OLD.id_producto;
	END
$$