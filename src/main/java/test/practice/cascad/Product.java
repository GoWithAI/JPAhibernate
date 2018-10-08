package test.practice.cascad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	private String productName;

	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	private List<Options> options;

	public Product() {

	}

	public Product(String productName) {
		super();
		this.productName = productName;
	}

	public Product(String productName, List<Options> options) {
		super();
		this.productName = productName;
		this.options = options;
	}

	public int getProductId() {
		return id;
	}

	public void setProductId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

}
