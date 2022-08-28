package be.sven.fullstack.dataaccess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
class OwnerRepositoryTest {
	
	@Autowired
	private OwnerRepository ownerRepo;

	@Test
	@Sql("owner-repo-unittest.sql")
	void testFindAll() {
		Iterable<Owner> ownerlist = ownerRepo.findAll();
		assertThat(ownerlist).hasSize(2);
	}
	
	@Test
	@Sql("owner-repo-unittest.sql")
	void testFindById() {
		Optional<Owner> owner = ownerRepo.findById(Long.valueOf(1));
		assertNotNull(owner.get());
		assertEquals("Sven", owner.get().getFirstName());
	}
	

}
