# 🎯 Project 72 – FoodHub – Zero Delivery Fee Food Delivery | Spring Boot + H2 + Bypass Full Stack

<p align="left">
<img src="https://img.shields.io/badge/Java-17-E76F00?logo=openjdk&logoColor=white" alt="Java 17">
<img src="https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot">
<img src="https://img.shields.io/badge/H2-Database-0040C0?logo=h2&logoColor=white" alt="H2">
<img src="https://img.shields.io/badge/Security-Bypass_permitAll-7C3AED" alt="Bypass">
<img src="https://img.shields.io/badge/Frontend-Single_HTML_Vanilla_JS-000000?logo=html5&logoColor=white" alt="Bypass Static">
<img src="https://img.shields.io/badge/Theme-FoodHub_Orange_Black-FF6B00" alt="FoodHub">
<img src="https://img.shields.io/badge/Status-Completed-20B000" alt="Completed">
<img src="https://img.shields.io/badge/Screenshots-24-FFB700" alt="24 Screenshots">
</p>

## 📖 Project Overview

FoodHub is Project 72 of Tier 7 – Full Stack Integration, built with Spring Boot 3.2.5, H2 Database, Spring Data JPA, Hibernate, Spring Security (Bypass Mode – permitAll) and Single File Premium Frontend served from `src/main/resources/static/`.

This project uses BYPASS FULL STACK architecture:
- Frontend and Backend run on SAME port 9194 – http://localhost:9194/
- No CORS issues, No separate React build – Single static/index.html with Vanilla JS
- Backend serves frontend directly – Deploy as 1 JAR
- Auth with ADMIN / OWNER / CUSTOMER role selector + Simple localStorage + Role Based UI
- Login required to Add/Edit/Delete – Role based UI – Food Click Detail View with Restaurant Contact – 24 Screenshots Verified

Backend provides REST endpoints:
- GET /api/foods – List all foods live – 10 foods – ₹2,453 portfolio
- POST /api/foods – Add new food (OWNER / ADMIN)
- PUT /api/foods/{id} – Edit food (OWNER / ADMIN)
- DELETE /api/foods/{id} – Delete food (OWNER / ADMIN)
- POST /api/auth/register – Create account ADMIN / OWNER / CUSTOMER – ravi CUSTOMER demo
- POST /api/auth/login – Login with username, password – Returns token + user + role

## ✨ Features

### 🔐 Authentication – Bypass Simple
- Login with Username, Password, Role (ADMIN / OWNER / CUSTOMER) – localStorage token
- Test accounts – admin/admin123 (ADMIN), owner/owner123 (OWNER), ravi/ravi123 (CUSTOMER) – 24 screenshots verified

### 🍛 Foods Feed – Real App – 10 Foods
- 3 sample foods auto-added via DataLoader – Hyderabad Biryani ₹299, Razole Fish Curry ₹199, Bangalore Dosa ₹99
- Added via UI real POST – Chicken Tikka Biryani ₹349, Paneer Butter Masala ₹250, Special Chicken 65 ₹179, Death By Chocolate Brownie ₹100, Razole Royyala Biryani ₹399, Special Andhra Chicken 65 ₹200, Challapalli Pulasa Pulusu Biryani ₹379
- Filters – All Foods / Veg / Non-Veg / Biryani / FastFood / Desserts – Instant JS filter
- Search – city/restaurant live – Hyderabad / Razole / Challapalli / Bangalore
- Portfolio – ₹2,453 – 10 foods – Fixed 3 foods bug with count<10 + deleteAll()

### 🍽️ Food Detail View – Main Feature V2
- Click any food card → Detail Modal 780px – Left image 420px – Right details
- Restaurant Details box – Owner: admin • Verified • Direct Contact – No Commission
- Buttons: Contact Restaurant / Order black + Add to Cart orange + Edit white + Delete red
- Cart – Added Challapalli Pulasa to cart! Total items:1 Total:₹379 – demo11, Added Hyderabad Biryani Total items:2 Total:₹648 – demo20 – 2 items • ₹599 • Checkout – demo23

### 🛡 Role Protection – ADMIN vs OWNER vs CUSTOMER
- ADMIN admin/admin123 – Can delete ANY – + Add Food green – Delete red all
- OWNER owner/owner123 – Can add own – + Add Food – 1 items • ₹349 • Checkout
- CUSTOMER ravi/ravi123 – No Add/Delete – Only order – Cart working – Zero Delivery Fee

## 🛠 Technologies Used

| Technology | Version | Purpose |
|---|---|---|
| Java | 17 | Backend language |
| Spring Boot | 3.2.5 | REST APIs, Embedded Tomcat – Port 9194 |
| Spring Data JPA / Hibernate | 6.4.4.Final | ORM |
| Spring Security | 6.2.4 | Bypass – permitAll() |
| H2 Database | 2.2.x | In-memory fooddb – h2-console |
| Frontend | Single static/index.html V2 – Vanilla JS | No React build – Same port |
| CSS | Pure CSS – Black #111827 + Orange #ff6b00 | Premium FoodHub |
| Maven | 3.9+ | Build |

## 📂 Project Structure
```
72-food-delivery-app/
├── src/main/java/com/fooddelivery/
│   ├── config/DataLoader.java – 3 users + 10 foods – Including Challapalli – Fixed 3 foods bug
│   ├── controller/FoodController.java – GET/POST/PUT/DELETE /api/foods
│   ├── controller/AuthController.java – POST /api/auth/login & register
│   ├── entity/Food.java – id, title, city, type, price, imageUrl, description, restaurantName, ownerId
│   ├── entity/User.java – id, username, password, role ADMIN/OWNER/CUSTOMER
│   └── repository/FoodRepository & UserRepository
├── src/main/resources/
│   ├── static/index.html – Full Real App V2 – 24 screenshots verified
│   └── application.properties – server.port=9194, jdbc:h2:mem:fooddb
├── screenshots/ – 24 premium images
├── pom.xml
└── README.md
```

## ▶ How to Run

```bash
git clone https://github.com/raviteja-dev950/72-food-delivery-app.git
cd 72-food-delivery-app
mvn clean install -DskipTests
mvn spring-boot:run
```

Open:
- http://localhost:9194/ – Frontend + Backend Same Port – 10 Foods
- http://localhost:9194/api/foods – Foods JSON – 10 foods
- http://localhost:9194/h2-console – JDBC URL jdbc:h2:mem:fooddb – sa – no password

## 🧪 API Testing
```bash
curl http://localhost:9194/api/foods
curl -X POST http://localhost:9194/api/auth/login -H "Content-Type: application/json" -d "{\"username\":\"admin\",\"password\":\"admin123\"}"
curl -X POST http://localhost:9194/api/foods -H "Content-Type: application/json" -H "Authorization: Bearer token" -d "{\"title\":\"Challapalli Pulasa Pulusu Biryani\",\"city\":\"Challapalli\",\"type\":\"NON_VEG\",\"price\":379.0,\"imageUrl\":\"https://images.unsplash.com/photo-1589302168068-964664d93dc0\",\"description\":\"Challapalli Famous Pulasa Fish Biryani\",\"restaurantName\":\"Challapalli Coastal Ruchulu\",\"ownerId\":2}"
```

## 📡 API Endpoints
| Method | Endpoint | Purpose |
|---|---|---|
| GET | /api/foods | 10 foods – ₹2,453 – 24 screenshots |
| POST | /api/foods | Add New Food – OWNER/ADMIN – Food Published! |
| PUT | /api/foods/{id} | Edit Food – V2 |
| DELETE | /api/foods/{id} | Delete – ADMIN any OWNER own |
| POST | /api/auth/register | Create Account – ravi CUSTOMER |
| POST | /api/auth/login | Login – token + user + role |

## 🗄 Database Note
DataLoader adds 3 users if count<10 deleteAll – admin ADMIN, owner OWNER, ravi CUSTOMER – 10 foods – Hyderabad 299, Razole Fish Curry 199, Bangalore Dosa 99, Chicken Tikka 349, Paneer 250, Chicken 65 179, Brownie 100, Royyala 399, Andhra Chicken 65 200, Challapalli Pulasa 379 – Fixed bug 3 foods only with count<10

## 📸 Screenshots – FoodHub Real App V2 – 24 Images

### 1. Guest View – 3 Foods – Zero Delivery Fee Hero
![Guest 3](screenshots/demo1.png)

### 2. Add New Food – Empty Modal
![Add Empty](screenshots/demo2.png)

### 3. Add New Food – Filled – Chicken Tikka Biryani Family Pack ₹349
![Add Chicken Tikka](screenshots/demo3.png)

### 4. Food Published Popup – Chicken Tikka
![Published Chicken Tikka](screenshots/demo4.png)

### 5. 4 Foods Grid – Chicken Tikka Added
![4 Foods](screenshots/demo5.png)

### 6. Add New Food – Filled – Paneer Butter Masala ₹250
![Add Paneer](screenshots/demo6.png)

### 7. Food Published Popup – Paneer
![Published Paneer](screenshots/demo7.png)

### 8. Add New Food – Filled – Special Chicken 65 ₹179
![Add Chicken 65](screenshots/demo8.png)

### 9. Food Published Popup – Chicken 65
![Published Chicken 65](screenshots/demo9.png)

### 10. Final 10 Foods Grid – ₹2,453 Portfolio
![10 Foods](screenshots/demo10.png)

### 11. Add to Cart – Challapalli Pulasa ₹379
![Cart Challapalli](screenshots/demo11.png)

### 12. Food Click Detail View – Challapalli Pulasa Pulusu Biryani ₹379 – Main Fix
![Detail Challapalli](screenshots/demo12.png)

### 13. Sign In Modal – CUSTOMER
![Login Customer](screenshots/demo13.png)

### 14. Sign In Modal – ADMIN
![Login Admin](screenshots/demo14.png)

### 15. Admin Dashboard – 10 Foods – admin•ADMIN – All Delete
![Admin 10](screenshots/demo15.png)

### 16. Sign In Modal – OWNER
![Login Owner](screenshots/demo16.png)

### 17. Owner Dashboard – 10 Foods – owner•OWNER
![Owner 10](screenshots/demo17.png)

### 18. Owner Dashboard with Cart – 1 items • ₹349 • Checkout
![Owner Cart](screenshots/demo18.png)

### 19. Sign In Modal – ravi CUSTOMER
![Login Ravi](screenshots/demo19.png)

### 20. Add to Cart – Hyderabad Biryani – 2 Items ₹648
![Cart Hyderabad](screenshots/demo20.png)

### 21. Food Click Detail View – Hyderabad Biryani ₹299
![Detail Hyderabad](screenshots/demo21.png)

### 22. Sign In Modal – ADMIN – Re-login
![Login Admin 2](screenshots/demo22.png)

### 23. Customer Dashboard – ravi•CUSTOMER – 10 Foods – 2 items • ₹599 • Checkout
![Customer 10](screenshots/demo23.png)

### 24. API Verification – /api/foods – 10 Foods JSON
![API Foods](screenshots/demo24.png)

## 🎯 Learning Outcomes – V2 – 24 Screenshots – Top 1% GitHub
- Bypass Full Stack – Single static/index.html V2 – Same port 9194 – Fixed 3 foods bug to 10
- H2 – count<10 + deleteAll() fix – 10 foods Including Challapalli Pulasa
- Food Detail View – Click card → Detail Modal + Restaurant Details + Contact + Cart + Edit Delete
- Cart – Added to cart! Total items:1 Total:₹379 – Total:₹648 – 2 items • Checkout – Zero Delivery Fee
- Role UI – ADMIN any OWNER own CUSTOMER only order – QuickDelete event.stopPropagation

## 🚀 Future Enhancements
- JWT + BCrypt – MySQL – My Restaurants filter – Wishlist/Cart DB – Order history – Image upload S3 – Pagination – Map Lat Long – Charts – Chat WebSocket – Deploy Render

## 👨💻 Author
### Vemula Leela Venkata Ravi Teja

Java Full Stack Developer – Razole, Andhra Pradesh

100 Java Full Stack Projects Challenge – 72 / 100 Completed – FoodHub V2 – Zero Delivery Fee

GitHub: raviteja-dev950 – 72-food-delivery-app


### Test Accounts – 24 Screenshots Verified
- admin/admin123 – ADMIN – Full access – 10 Foods – Delete ANY
- owner/owner123 – OWNER – Add own – 10 Foods – 1 item 349 checkout
- ravi/ravi123 – CUSTOMER – View only – Cart – 2 items 599 checkout – Zero Delivery Fee

## ⭐ Support
If helpful, give ⭐ Star on GitHub! 72 is better than 71 with 24 screenshots + Cart + 3 Foods Bug Fixed!

### Repo
https://github.com/raviteja-dev950/72-food-delivery-app

```bash
mvn spring-boot:run
# Open http://localhost:9194/
# owner/owner123 – 10 Foods – Click Challapalli card → Detail Modal → Add to Cart → 1 item 379 → 2 items 648 → Checkout
# ravi/ravi123 – CUSTOMER – 10 Foods – No Add/Delete – Only order – Zero Delivery Fee – Like Swiggy/Zomato
# admin/admin123 – ADMIN – 10 Foods – Delete ANY – + Add Food
```
