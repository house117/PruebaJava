CREATE TABLE Cajeros(
 
Cajero int primary key not null AUTO_INCREMENT,
 
NomApels nvarchar(255)
 

);

CREATE TABLE Maquinas_Registradoras(
Maquina int primary key not null AUTO_INCREMENT,
Piso int
);

CREATE TABLE Productos(
Producto int primary key not null AUTO_INCREMENT,
Nombre nvarchar(100),
Precio decimal(15,2)
);

CREATE TABLE Venta(
Cajero int,
Producto int,
Maquina int,
FOREIGN KEY (Cajero) REFERENCES Cajeros(Cajero),
FOREIGN KEY (Producto) REFERENCES Productos(Producto),
FOREIGN KEY (Maquina) REFERENCES Maquinas_Registradoras(Maquina)
);

INSERT INTO Cajeros(NomApels) VALUES("José Luis Flores García");
INSERT INTO Cajeros(NomApels) VALUES("Julián Ramirez");
INSERT INTO Cajeros(NomApels) VALUES("Pedro Garza");
INSERT INTO Cajeros(NomApels) VALUES("Jesús Carreño");

INSERT INTO Maquinas_Registradoras(Piso) VALUES(1);
INSERT INTO Maquinas_Registradoras(Piso) VALUES(2);
INSERT INTO Maquinas_Registradoras(Piso) VALUES(3);
INSERT INTO Maquinas_Registradoras(Piso) VALUES(4);

INSERT INTO Productos(Nombre, Precio) VALUES("Galletas", 12.5);
INSERT INTO Productos(Nombre, Precio) VALUES("Sabritas", 10.0);
INSERT INTO Productos(Nombre, Precio) VALUES("Doritos", 11.0);
INSERT INTO Productos(Nombre, Precio) VALUES("Gansito", 8.5);
INSERT INTO Productos(Nombre, Precio) VALUES("Agua", 7.5);
INSERT INTO Productos(Nombre, Precio) VALUES("Tostadas", 20.0);


INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(1,1,1);
INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(3,2,1);
INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(1,3,1);
INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(2,4,3);
INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(3,5,1);
INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(1,6,1);
INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(1,6,1);
INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(1,3,1);
INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(2,4,3);
INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(3,5,1);
INSERT INTO Venta(Cajero, Producto, Maquina) VALUES(1,6,1);

/*2 Numero de ventas de cada producto, ordenado de mas a menos ventas*/
SELECT Productos.nombre,  COUNT(Venta.Producto) FROM Venta INNER JOIN Productos where Productos.Producto=Venta.Producto GROUP BY Venta.Producto DESC;
/*3 Informe completo de ventas*/
select c.NomApels, p.Nombre, p.Precio, m.Maquina
from Cajeros c INNER JOIN Productos p INNER JOIN Maquinas_Registradoras m INNER JOIN Venta v 
where v.Cajero=c.Cajero AND v.Producto=p.Producto AND v.Maquina=m.Maquina;

/*4 Ventas totales de cada piso*/
/*select SUM(p.Precio), v.Maquina from Venta v INNER JOIN Productos p where p.Producto = v.Producto GROUP BY v.Maquina; Venta por maquina*/
select m.Piso, SUM(p.Precio) from Venta v INNER JOIN Productos p INNER JOIN Maquinas_Registradoras m where p.Producto = v.Producto AND m.Maquina = v.Maquina GROUP BY m.Piso;

/*5 Código y nombre de cada cajero junto con el importe de sus ventas*/
select c.Cajero, c.NomApels, SUM(p.Precio) from Venta v INNER JOIN Productos p INNER JOIN Cajeros c 
where p.Producto = v.Producto AND c.Cajero = v.Cajero GROUP BY c.Cajero;

/*6 Código y nombre de cajeros que realizaron ventas
 * en pisos cuyas ventas totales sean inferiores a los 5000 pesos*/

select c.Cajero, c.NomApels from 
Cajeros c INNER JOIN Maquinas_Registradoras m INNER JOIN Venta v
where c.Cajero = v.Cajero AND m.Maquina = v.Maquina AND m.Piso IN 
(select m.Piso from Venta v INNER JOIN Productos p 
INNER JOIN Maquinas_Registradoras m where p.Producto = v.Producto AND m.Maquina = v.Maquina 
GROUP BY m.Piso HAVING SUM(p.Precio) < 5000) 
GROUP BY c.Cajero


 



