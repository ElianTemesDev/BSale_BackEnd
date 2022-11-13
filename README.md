# BSale_BackEnd  
El proyect esta realizado utilizando Spring Boot 2.7.5 con Java 17, ademas de los modulos de Spring, utilizo la biblioteca del proyecto  
Lombok para reducir el boilerplate por medio de anotations en los controllers, entities y demas, la arquitectura es una por capas donde  
existen entidades/repositorios/servicios/data-transfer-objects/controladores y ademas existe una carpeta especifica para excepciones y predicados  

API del desafio  

Product:   
Listar todos, obtencion singular, busqueda por texto parcial.  
Los productos pueden ser llamados tanto por Id como por nombre, categoria y la combinacion de nombre y categoria especifica.  

Al realizar una petición HTTP, el servicio retornara un JSON con la siguiente estructura:   
```JSON
   {
        "id": 5,
        "name": "ENERGETICA MR BIG",
        "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/misterbig3308256.jpg",
        "price": 1490.0,
        "discount": 20,
        "category": {
            "id": 1,
            "name": "bebida energetica"
        }
    }
``` 
    
* id, identificador del producto (long)  
* name, nombre del producto (String)  
* urlImage, url de la imagen pertinente al producto (String)  
* price, precio del producto (double)  
* discount, descuento especifico del producto (int)  
* category, objeto que contiene los datos de la categoria a la que pertenece el producto (Category)  

GET Lista de todos los productos: /api/products  
GET Producto por Id: /api/product/{id}  
GET Producto por nombre: /api/product?name={nombre}  
GET Producto por categoria: /api/product?category={categoria}  
GET Producto por nombre y categoria /api/product?name={nombre}&category={categoria}  

Category:  
Listar todos, obtencion singular.  
Las categorias pueden ser llamadas singularmente por Id o se pueden listar todas.  

Al realizar una petición HTTP, el servicio retornara un JSON con la siguiente estructura:   
```JSON
{
    "id": 1,
    "name": "bebida energetica"
}
``` 

* id, identificador de la categoria (long)  
* name, nombre de la categoria (String)  

GET Lista de todas las categorias: /api/categories  
GET Categoria por Id: /api/category/{id}  
