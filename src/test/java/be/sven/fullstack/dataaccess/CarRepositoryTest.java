package be.sven.fullstack.dataaccess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
class CarRepositoryTest {
	
	@Autowired
	private CarRepository carRepo;

	@Test
	@Sql("car-repo-unittest.sql")
	void testFindAll() {
		Iterable<Car> carlist = carRepo.findAll();
		assertThat(carlist).hasSize(3);
	}
	
	@Test
	@Sql("car-repo-unittest.sql")
	void testFindById() {
		Optional<Car> car = carRepo.findById(Long.valueOf(1));
		assertNotNull(car.get());
		assertEquals("Ford", car.get().getBrand());
		assertNotNull(car.get().getOwner());
		assertEquals("Sven", car.get().getOwner().getFirstName());
	}
	
	@Test
	@Sql("car-repo-unittest.sql")
	void testFindByBrand() {
		Iterable<Car> carlist = carRepo.findByBrand("Toyota");
		assertThat(carlist).hasSize(1);
		assertEquals("Toyota", carlist.iterator().next().getBrand());
		assertNotNull(carlist.iterator().next().getOwner());
		assertEquals("Sabrina", carlist.iterator().next().getOwner().getFirstName());

	}
	

	@Test
	@Sql("car-repo-unittest.sql")
	void testFindByBrandAndModel() {
		Iterable<Car> carlist = carRepo.findByBrandAndModel("Toyota","Prius");
		assertThat(carlist).hasSize(1);
		assertEquals("Toyota", carlist.iterator().next().getBrand());
	}
	
	
	@Test
	@Sql("car-repo-unittest.sql")
	void testFindByBrandOrColor() {
		Iterable<Car> carlist = carRepo.findByBrandOrColor("Toyota","Red");
		assertThat(carlist).hasSize(2);
		Iterator<Car> it = carlist.iterator();
		assertEquals("Ford", it.next().getBrand());
		assertEquals("Toyota", it.next().getBrand());
	}
	
	@Test
	@Sql("car-repo-unittest.sql")
	void testFindByBrandLike() {
		Iterable<Car> carlist = carRepo.findByBrandLike("yot");
		assertThat(carlist).hasSize(1);
		assertEquals("Toyota", carlist.iterator().next().getBrand());
	}



}
