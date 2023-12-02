# Trabajo-final-Lab
Para iniciar la aplicación primeramente se debe contar tanto con docker-compose.

-Primero nos ubicamos en la carpeta biblioteca, donde se encuentra nuestra api de springboot, y ejecutaremos el siguiente comando en una terminal:

  ./mvnw clean package -DskipTests
  
-Luego en la carpeta raíz de la aplicación, ejecutaremos el siguiente comando docker:

  docker-compose build
  docker-compose up
  
-Esto hará que se levanten los contenedores de Docker.
-Por último nos dirigiremos a un navegador web e ingresamos la siguiente url "http://localhost:5173/".
