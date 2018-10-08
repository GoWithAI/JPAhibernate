package test.practice.cascad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductRespository {

	@Autowired
	EntityManager entityManager;

	public void addProductWithOptions() {
		List<Options> listOptions = new ArrayList<>();

		Product product = new Product("Books");
		entityManager.persist(product);

		for (int i = 0; i < 100; i++) {
			Options opt = new Options("label-" + i, "value-" + i);
			opt.setProduct(product);
			listOptions.add(opt);
			entityManager.persist(opt);
		}

	}
	
	public void deleteProduct() {
		Product retivedProduct = entityManager.find(Product.class, 1);
		entityManager.remove(retivedProduct);
	}

}
