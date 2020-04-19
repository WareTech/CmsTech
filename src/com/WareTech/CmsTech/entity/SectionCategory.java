package com.WareTech.CmsTech.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SectionCategory
    extends AbstractPersistentObject
{
    	@ManyToOne
    	@JoinColumn(name="sectionId")
    	protected Section section;
    	@ManyToOne
    	@JoinColumn(name="categoryId")
    	protected Category category;
    	
		public Section getSection() {
			return section;
		}
		public void setSection(Section section) {
			this.section = section;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
}
