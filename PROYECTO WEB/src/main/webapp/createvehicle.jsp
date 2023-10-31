<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Crear Vehículo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            background-color: #ffffff;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
            max-width: 300px;
            padding: 20px;
            border-radius: 5px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            color: #ffffff;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <form action="createVehicle" method="post">
        <label for="plate">Placa del vehículo:</label>
        <input type="text" id="plate" name="plate">
        <label for="entryTime">Hora de entrada:</label>
        <input type="number" id="entryTime" name="entryTime">
        <label for="exitTime">Hora de salida:</label>
        <input type="number" id="exitTime" name="exitTime">
        <label for="location">Ubicación:</label>
        <input type="text" id="location" name="location">
        <label for="vehicleType">Tipo de vehiculo:</label>
        <select id="vehicleType" name="vehicleType">
            <option value="carro">Carro</option>
            <option value="motocicleta">Motocicleta</option>
            <option value="cicla">Cicla</option>
        </select>
        <input type="submit" value="Crear Vehículo">
    </form>
</body>
</html>
