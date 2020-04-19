package com.WareTech.CmsTech.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductCategory
    extends AbstractPersistentObject
{
    	@ManyToOne
    	@JoinColumn(name="productId")
    	protected Product product;
    	@ManyToOne
    	@JoinColumn(name="categoryId")
    	protected Category category;
    	
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
}
