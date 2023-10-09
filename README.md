# Lemonstore
To start/run this application go to the proect repo 

Run the Spring boot application with the java -jar command:
`$ java -jar target/myapplication-0.0.1-SNAPSHOT.jar`

Run the Spring boot application using Maven:
`$ mvn spring-boot:run`

## ENDPOINTS
Product Endpoints

1. Add a New Product
HTTP Method: POST  
Endpoint: /api/cash-register/products  
Description: Add a new product to the Lemon Store inventory.   
Request Body: JSON representation of the product to be added.   
Response: Returns the added product with its generated productId.   

3. Get All Products  
HTTP Method: GET   
Endpoint: /api/cash-register/products    
Description: Retrieve a list of all products available in the Lemon Store inventory.    
Response: Returns a JSON array containing all products.    

4. Get Product by ID    
HTTP Method: GET    
Endpoint: /api/cash-register/products/{productId}    
Description: Retrieve a specific product from the Lemon Store inventory by its unique productId.    
Path Variable: productId - The ID of the product to retrieve.    
Response: Returns the product with the specified productId if found; otherwise, returns a 404 Not Found response.    

5. Delete a Product
HTTP Method: DELETE    
Endpoint: /api/cash-register/products/{productId}    
Description: Delete a product from the Lemon Store inventory by its unique productId.    
Path Variable: productId - The ID of the product to delete.    
Response: No content (HTTP status code 204) if the deletion is successful.    


Sale Endpoints

1. Add a Sale    
HTTP Method: POST    
Endpoint: /api/cash-register/sales    
Description: Record a new sale transaction in the Lemon Store.    
Request Body: JSON representation of the sale to be recorded.    
Response: Returns the recorded sale with its generated saleId.    

2. Get All Sales
HTTP Method: GET    
Endpoint: /api/cash-register/sales    
Description: Retrieve a list of all sales transactions recorded in the Lemon Store.    
Response: Returns a JSON array containing all recorded sales.    

3. Get Sale by ID
HTTP Method: GET    
Endpoint: /api/cash-register/sales/{saleId}    
Description: Retrieve a specific sale transaction recorded in the Lemon Store by its unique saleId.    
Path Variable: saleId - The ID of the sale to retrieve.    
Response: Returns the sale with the specified saleId if found; otherwise, returns a 404 Not Found response.    

4. Delete a Sale
HTTP Method: DELETE    
Endpoint: /api/cash-register/sales/{saleId}    
Description: Delete a recorded sale transaction from the Lemon Store by its unique saleId.    
Path Variable: saleId - The ID of the sale to delete.    
Response: No content (HTTP status code 204) if the deletion is successful.    



Application Properties of Dev and Prod   

Development Profile ("dev")   
Profile Activation: Uncomment the following line to activate the development profile:   

spring.profiles.active=dev   
Purpose: The development profile is intended for local development and testing. It enables features such as detailed logging and may use an in-memory database for rapid development.   

Production Profile ("prod")   
Profile Activation: Uncomment the following line to activate the production profile   


spring.profiles.active=prod   
Purpose: The production profile is used for the live production environment. It should be configured with optimized settings and connect to the production database and services.      














