package com.WareTech.CmsTech.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SectionLabel
    extends AbstractPersistentObject
{
    	@ManyToOne
    	@JoinColumn(name="sectionId")
    	protected Section section;
    	@ManyToOne
    	@JoinColumn(name="labelId")
    	protected Label label;
    	
		public Section getSection() {
			return section;
		}
		public void setSection(Section section) {
			this.section = section;
		}
		public Label getLabel() {
			return label;
		}
		public void setLabel(Label label) {
			this.label = label;
		}
}
