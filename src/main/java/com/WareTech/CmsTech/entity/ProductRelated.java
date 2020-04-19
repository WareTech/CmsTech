package com.WareTech.CmsTech.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductRelated
    extends AbstractPersistentObject
{
    	@ManyToOne
    	@JoinColumn(name="productId")
    	protected Product product;
    	@ManyToOne
    	@JoinColumn(name="relatedId")
    	protected Product related;
    	
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public Product getRelated() {
			return related;
		}
		public void setRelated(Product related) {
			this.related = related;
		}
}
