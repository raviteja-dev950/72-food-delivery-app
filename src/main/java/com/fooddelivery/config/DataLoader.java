package com.fooddelivery.config;
import com.fooddelivery.entity.Food;
import com.fooddelivery.entity.User;
import com.fooddelivery.repository.FoodRepository;
import com.fooddelivery.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UserRepository ur, FoodRepository fr){
        return args -> {
            if(fr.count() < 10){
                fr.deleteAll();
                ur.deleteAll();

                User u1 = new User();
                u1.setUsername("admin");
                u1.setPassword("admin123");
                u1.setRole("ADMIN");
                ur.save(u1);

                User u2 = new User();
                u2.setUsername("owner");
                u2.setPassword("owner123");
                u2.setRole("OWNER");
                ur.save(u2);

                User u3 = new User();
                u3.setUsername("ravi");
                u3.setPassword("ravi123");
                u3.setRole("CUSTOMER");
                ur.save(u3);

                add(fr, "Hyderabad Biryani", "Hyderabad", "BIRYANI", 299.0, "https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?w=600", "Authentic Hyderabad Dum Biryani - Spicy and Aromatic - Family Pack", "Paradise Biryani");
                add(fr, "Razole Fish Curry", "Razole", "NON_VEG", 199.0, "https://images.unsplash.com/photo-1555939594-58d7cb561ad1?w=600", "Traditional Razole Fish Curry - Fresh Catch - Coastal Andhra Style", "Godavari Spice");
                add(fr, "Bangalore Masala Dosa", "Bangalore", "VEG", 99.0, "https://images.unsplash.com/photo-1668236543090-82eba5ee5976?w=600", "Crispy Masala Dosa with Coconut Chutney - Authentic South Indian", "Udupi Garden");
                add(fr, "Chicken Tikka Biryani Family Pack", "Hyderabad", "BIRYANI", 349.0, "https://images.unsplash.com/photo-1589302168068-964664d93dc0?w=600", "Hyderabad Famous Chicken Tikka Dum Biryani - Boneless chicken tikka", "Bawarchi Restaurant");
                add(fr, "Paneer Butter Masala with Naan", "Razole", "VEG", 250.0, "https://images.unsplash.com/photo-1603894584373-5ac82b2ae398?w=600", "Creamy Paneer Butter Masala - Fresh paneer cubes in rich tomato butter gravy", "Godavari Spice");
                add(fr, "Special Chicken 65", "Razole", "FASTFOOD", 179.0, "https://images.unsplash.com/photo-1603360946369-dc9bb6258143?w=600", "Spicy Andhra Chicken 65 - Deep fried chicken with curry leaves", "Razole Fast Food Corner");
                add(fr, "Death By Chocolate Brownie", "Bangalore", "DESSERT", 100.0, "https://images.unsplash.com/photo-1606313564200-e75d5e30476c?w=600", "Warm Chocolate Brownie with vanilla ice cream - Rich chocolate", "The Dessert Studio");
                add(fr, "Razole Royyala Biryani", "Razole", "NON_VEG", 399.0, "https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?w=600", "Authentic Coastal Prawn Biryani - Fresh Godavari prawns", "Coastal Biryani House");
                add(fr, "Special Andhra Chicken 65", "Razole", "FASTFOOD", 200.0, "https://images.unsplash.com/photo-1555939594-58d7cb561ad1?w=600", "Spicy Andhra Chicken 65 - Extra spicy - 350g", "Razole Fast Food Corner");
                add(fr, "Challapalli Pulasa Pulusu Biryani", "Challapalli", "NON_VEG", 379.0, "https://images.unsplash.com/photo-1589302168068-964664d93dc0?w=600", "Challapalli Famous Pulasa Fish Biryani - Godavari Pulasa (Hilsa) fish, seeraga samba rice, traditional Krishna district pulusu masala", "Challapalli Coastal Ruchulu");
                
                System.out.println("Foods added: 10 - Including Challapalli");
            }
        };
    }

    void add(FoodRepository fr, String title, String city, String type, Double price, String img, String desc, String rest){
        Food f = new Food();
        f.setTitle(title);
        f.setCity(city);
        f.setType(type);
        f.setPrice(price);
        f.setImageUrl(img);
        f.setDescription(desc);
        f.setRestaurantName(rest);
        fr.save(f);
    }
}