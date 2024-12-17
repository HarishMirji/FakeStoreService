# Fake Store Product Service

## Overview
The **Fake Store Product Service** is a RESTful API built using **Spring Boot**. It allows users to interact with a product catalog by performing CRUD operations, including product creation, retrieval, updates, and deletions. The service also supports product categorization and limited product queries.

## Features
- **Create Product**: Adds a new product to the catalog.
- **Get Product by ID**: Retrieves a product based on its unique ID.
- **Delete Product by ID**: Deletes a product from the catalog.
- **Get All Categories**: Retrieves all available product categories.
- **Get Products by Category**: Fetches products belonging to a specific category.
- **Get All Products**: Lists all available products.
- **Get Limited Products**: Retrieves a limited number of products.
- **Update Product**: Updates an existing product's details.

## Endpoints

### Product Endpoints
- `POST /products/create` - Create a new product.
- `GET /products/{id}` - Get product by ID.
- `DELETE /products/{id}` - Delete product by ID.
- `GET /products` - Get all products.
- `GET /products/limited?limit={limit}` - Get limited number of products.

### Category Endpoints
- `GET /products/categories` - Get all product categories.
- `GET /products/categories/{category}` - Get products by category.

### Update Endpoints
- `PUT /products/update` - Update product details.

## Example Usage

1. **Create a Product**:
   ```bash
   POST /products/create
   Body: {
     "title": "Product Title",
     "description": "Product Description",
     "price": 99.99,
     "image": "image_url",
     "category": "electronics"
   }
2. **Create a Product**:
   ```bash
   GET /products/{id}
  
3. **Update Product**:
   ```bash
   PUT /products/updatee
   Body: {
     "id": 1,
     "title": "Updated Title",
     "description": "Updated Description",
     "price": 199.99,
     "image": "updated_image_url",
     "category": "fashion"
   }
## Dependencies
- **Spring Boot**
- **Spring Web**

## How to Run
1. Clone the repository.
2. Run the Spring Boot application.
3. Access the API at `http://localhost:8080/products`.

  
   
