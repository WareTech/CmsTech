package com.WareTech.CmsTech.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SectionProduct
    extends AbstractPersistentObject
{
    	@ManyToOne
    	@JoinColumn(name="sectionId")
    	protected Section section;
    	@ManyToOne
    	@JoinColumn(name="productId")
    	protected Product product;
    	
		public Section getSection() {
			return section;
		}
		public void setSection(Section section) {
			this.section = section;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
}
