# JavaTechnology-midterm
## ERD
![erd](https://user-images.githubusercontent.com/74971162/230759390-5cad6c94-b15d-4f07-8d52-3a676a422575.png)
## Flow Chart

## Installation
You can use your favorite IDE (IntelliJ/Esclipse) to run the application

## Application UI
Log in

![login](https://user-images.githubusercontent.com/74971162/230759829-374e03dd-a730-415a-bad4-a5162a921ca0.png)

Homepage

![homepage](https://user-images.githubusercontent.com/74971162/230759759-50fb46a4-6460-4169-b515-6fe3751b5847.png)

Cart

![cart](https://user-images.githubusercontent.com/74971162/230759792-d2b76f03-2f4f-4c79-8ae1-1798d42f4ff1.png)

Checkout

![checkout](https://user-images.githubusercontent.com/74971162/230759802-32e236d4-2340-44f6-b646-69985439fee8.png)

Thank you 

![thanks](https://user-images.githubusercontent.com/74971162/230759809-7ab9a60d-cffa-4809-99a6-03689f1f178c.png)

Admin page

![adminpage](https://user-images.githubusercontent.com/74971162/230759820-3ae4d746-b644-420e-a409-756913c863b1.png)

Category Management

![category](https://user-images.githubusercontent.com/74971162/230759847-e0b1e8c3-e6b9-4db4-9b5a-b035eec3964f.png)

Add Category

![addcategory](https://user-images.githubusercontent.com/74971162/230759861-466b3d67-af6b-49ba-a512-e18bdccedac3.png)

Product Management

![product](https://user-images.githubusercontent.com/74971162/230759870-3af773aa-98d5-4506-a317-987ce0f7b2f0.png)

Add Product

![addproduct](https://user-images.githubusercontent.com/74971162/230759877-d4570bdd-347d-4270-a631-cc324163fa27.png)

Bill Management

![bill](https://user-images.githubusercontent.com/74971162/230759883-91c0cb5a-2c24-473e-8388-dc0340d854cc.png)

## HTTP Headers
### User
Homepage: [localhost:8080](http://localhost:8080/) -> method Get

Filter Product: http://localhost:8080/home/filter -> method Post

Search Product: http://localhost:8080/home/search -> method Post

View Product Detail: http://localhost:8080/home/product/detail/2 -> method Get

Add Product to Cart: htt://localhost:8080/home/cart/add/{id} -> method Post

View Cart: http://localhost:8080/home/cart -> method Get

Checkout product: http://localhost:8080/home/cart/checkout -> method Get

Thank you page after checkout: http://localhost:8080/home/cart/checkout/thanks -> method Post 

Login Page: http://localhost:8080/login -> Spring security force user to login page cause cannot go to the admin page without login the login page just accept the admin with username and password is admin, usual user cannot go to admin page

### Admin
Admin Page: http://localhost:8080/admin -> Spring security redirect after check the login information

View category management: http://localhost:8080/admin/category/list -> method Get

Add category: http://localhost:8080/admin/category/add -> method Get

Processing add category to database: http://localhost:8080/admin/category/get -> method Post

Edit category: http://localhost:8080/admin/category/edit/{id} -> method Get

Delete category: http://localhost:8080/admin/category/delete/{id} -> method Get

View product management: http://localhost:8080/admin/product/list -> method Get

Add Product: http://localhost:8080/admin/product/add -> method Get

Processing add product to database: http://localhost:8080/admin/product/get -> method Post 

Delete Product: http://localhost:8080/admin/product/delete/{id} -> method Get

Edit Product: http://localhost:8080/admin/product/edit/{id} -> method Get

## Explaination about the application

The application for any kind of user can buy product and just provide pay by cash, user after choose product they like the application will direct to checkout page when the user want to checkout products. User can search products by category, brands, colors and price also they can remove product from shopping cart if they do not want to buy anymore. User do not need to create an account to buy products. 

The login page just for admin who want to go to the admin page to manage the application. If admin does not login and want to go to the admin page the application will not let it happend because to avoid any user will find the admin page and destroy the application, I did configure the spring security just for admin use it and it only have 1 account for admin so it does not have any register page. Admin will have permission to add, edit and delete category and product also delete the bill order of user.

## Code stucture 
There are 4 package and 1 folder resource in the source code:

  + config: contain the spring security configuration
 
  + controller: contain the HomeController, CartController, ProductController, CategoryController, BillController process for user and admin request
  
  + dto: contain ProductDTO which will have the categoryid in it 
  
  + model: 
  
      - contain BillOrder: id of bill, name of products customer buy, total money they will pay. Name, address, age, phone of customer  
      
      - Category: id and name of category
      
      - Product: id, name, price, brand, color, image(the name of path of product) of product
      
      - Customer: id, name, age, address, phone of customer
      
      - ProductCart: id of productCart, name of product customer choose; price, brand, color, image of product; subtotal base on the quantity they choose
      
  + repository: BillOrderRepository, CategoryRepository, CustomerRepository, ProductCartRepository, ProductRepository
  
  + service: 
 
      - interface BillOrderService: getAllBill(), addBill(BillOrder billOrder), removeBillById(long id), getBillById(long id)
      
      - BillOrderServiceImpl: implements all methods of BillOrderService
      
      - interface CategoryService: getAllCategory(), addCategory(Category category), removeCategoryById(long id), getCategoryById(long id)
      
      - CategoryServiceImpl: implements all methods of CategoryService
      
      - interface CustomerService: getAllCustomer(), addCustomer(Customer customer), removeCustomerById(long id), getCustomerById(long id)
      
      - CustomerServiceImpl: implements all methods of CustomerService
      
      - interface ProductCartService: getAllProductCart(), addProductCart(ProductCart productCart), removeProductCartById(long id), getProductCartById(long id),               removeAllProductCart()
      
      - ProductCartServiceImpl: implements all methods of ProductCartService
      
      - interface ProductService: getAllProduct(), addProduct(Product product), removeProductById(long id), getProductById(long id), searchProductByName(String ar)
      
      - ProductServiceImpl: implements all methods of ProductService
      
  + resources: 
 
      - static: folders css, image, javascript
      
      - templates: contains file html
      
      - application.properties








