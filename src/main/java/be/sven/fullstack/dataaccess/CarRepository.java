package be.sven.fullstack.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

	List<Car> findByBrand(String brand);
	List<Car> findByColor(String color);
	List<Car> findByYear(String year);
	
	List<Car> findByBrandAndModel(String brand,String model);
	List<Car> findByBrandOrColor(String brand, String color);
	
	List<Car> findByBrandOrderByYearAsc(String brand);
	
	@Query("select c from Car c where c.brand like %?1%")
	List<Car> findByBrandLike(String brand);

}
