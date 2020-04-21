package com.TTN.AmazonWebsite;

import com.TTN.AmazonWebsite.Entity.Product.Category;
import com.TTN.AmazonWebsite.Entity.Product.Product;
import com.TTN.AmazonWebsite.Entity.User.Seller;
import com.TTN.AmazonWebsite.Repo.CategoryRepo;
import com.TTN.AmazonWebsite.Repo.ProductRepo;
import com.TTN.AmazonWebsite.Repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class AmazonWebsiteApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;


	@Autowired
	CategoryRepo categoryRepo;


	@Autowired
	ProductRepo productRepo;

	@Test
	void contextLoads() {
	}

	@Test

	public void createEntity() {

		/*Customer user=new Customer(817863898);
		HashSet<User> users= new HashSet<User>();
		user.setFirst_name("pranjal");
		user.setMiddle_name("kumar");
		user.setLast_name("pandey");
		user.setEmail("pranjalpandey009@gmail.com");
		user.setDeleted(true);
		user.setActive(true);
		user.setPassword(passwordEncoder.encode("pranjal"));
		users.add(user);
*/

	/*	Role role=new Role();
		HashSet<Role> roles=new HashSet<>();
		role.setAuthority("ADMIN");
		role.setUsersSet(users);
		roles.add(role);
		user.setRoleSet(roles);


		userRepository.save(user);


*/
		Category category=categoryRepo.findById(2).get();
		Seller seller= (Seller) userRepository.findById(2).get();

		Product product=new Product();
		product.setActive(true);
		product.setBrand("Mi");
		product.setCancellable("yes");
		product.setName("pro f1");
		product.setReturnable("no");
		product.setCategory(category);
		product.setProductseller(seller);

		productRepo.save(product);

	}
}