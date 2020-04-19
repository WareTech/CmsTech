package com.WareTech.CmsTech.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductLabel
    extends AbstractPersistentObject
{
    	@ManyToOne
    	@JoinColumn(name="productId")
    	protected Product product;
    	@ManyToOne
    	@JoinColumn(name="labelId")
    	protected Label label;
    	
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public Label getLabel() {
			return label;
		}
		public void setLabel(Label label) {
			this.label = label;
		}
}
