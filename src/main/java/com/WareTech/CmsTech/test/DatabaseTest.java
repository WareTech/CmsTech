package com.WareTech.CmsTech.test;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.WareTech.CmsTech.database.Database;
import com.WareTech.CmsTech.entity.Access;
import com.WareTech.CmsTech.entity.Alert;
import com.WareTech.CmsTech.entity.AlertUser;
import com.WareTech.CmsTech.entity.Category;
import com.WareTech.CmsTech.entity.Configuration;
import com.WareTech.CmsTech.entity.CurrencyExchange;
import com.WareTech.CmsTech.entity.Label;
import com.WareTech.CmsTech.entity.Product;
import com.WareTech.CmsTech.entity.ProductCategory;
import com.WareTech.CmsTech.entity.ProductLabel;
import com.WareTech.CmsTech.entity.ProductRelated;
import com.WareTech.CmsTech.entity.Section;
import com.WareTech.CmsTech.entity.SectionCategory;
import com.WareTech.CmsTech.entity.SectionLabel;
import com.WareTech.CmsTech.entity.SectionProduct;
import com.WareTech.CmsTech.entity.User;
import com.WareTech.CmsTech.entity.UserAccess;

public class DatabaseTest 
{
	static public void main(String[] args)
		throws Exception
	{
		try
		{
			Database.getCurrentSession().beginTransaction();
			test();
			Database.getCurrentSession().getTransaction().commit();
//			Database.getCurrentSession().getTransaction().rollback();
		}
		catch(Throwable throwable)
		{
			throwable.printStackTrace();
			Database.getCurrentSession().getTransaction().rollback();
			System.exit(-1);
		}
		finally
		{
			Database.getCurrentSession().close();
		}

		System.exit(0);
	}
	
	static public void test()
		throws Exception
	{
		for (int index = 1; index < 10; index++)
		{
			User user = new User();
			user.setUsername("Username" + index);
			user.setPassword("Password" + index);
			Database.getCurrentSession().save(user);
		}
		
		for (int index = 1; index < 10; index++)
		{
			Access access  = new Access();
			access.setValue("Value" + index);
			access.setDescription("Description" + index);
			Database.getCurrentSession().save(access);
		}
		
		List<User> userList = Database.getCurrentSession().createQuery("FROM User").list();
		List<Access> accessList = Database.getCurrentSession().createQuery("FROM Access").list();
		for(User user : userList)
		{
			for(Access access : accessList)
			{
				UserAccess userAccess = new UserAccess();
				userAccess.setUser(user);
				userAccess.setAccess(access);
				Database.getCurrentSession().save(userAccess);
			}
		}
		
		for (int index = 1; index < 10; index++)
		{
			Alert alert  = new Alert();
			alert.setDescription("Description" + index);
			Database.getCurrentSession().save(alert);
		}
		
		List<Alert> alertList = Database.getCurrentSession().createQuery("FROM Alert").list();
		for(User user : userList)
		{
			for(Alert alert : alertList)
			{
				AlertUser alertUser = new AlertUser();
				alertUser.setUser(user);
				alertUser.setAlert(alert);
				alertUser.setDate(new Time(System.currentTimeMillis()));
				Database.getCurrentSession().save(alertUser);
			}
		}
		
		Category parentCategory = null;
		for (int index = 1; index < 10; index++)
		{
			Category category = new Category();
			category.setName("Name" + index);
			if (parentCategory != null)
			{
				category.setParent(parentCategory);	
			}
			Database.getCurrentSession().save(category);
			parentCategory = category;
		}
		
		for (int index = 1; index < 10; index++)
		{
			Configuration configuration = new Configuration();
			configuration.setKey("Key" + index);
			configuration.setValue("Value" + index);
			Database.getCurrentSession().save(configuration);
		}
		
		for (int index = 1; index < 10; index++)
		{
			CurrencyExchange currencyExchange = new CurrencyExchange();
			currencyExchange.setAmount(Float.valueOf(index));
			currencyExchange.setDate(new Date());
			currencyExchange.setCurrent(Boolean.FALSE);
			Database.getCurrentSession().save(currencyExchange);
		}
		
		for (int index = 1; index < 10; index++)
		{
			Label label = new Label();
			label.setName("Name" + index);
			Database.getCurrentSession().save(label);
		}
		
		for (int index = 1; index < 100; index++)
		{
			Product product = new Product();
			product.setAvailability(index % 2 == 0 ? Product.AVAILABILITY_48HS : Product.AVAILABILITY_72HS);
			product.setDescription("Description" + index);
			product.setDiscount(index % 100);
			product.setName("Name" + index);
			product.setPrice(Float.valueOf(index));
			product.setStock(index);
			Database.getCurrentSession().save(product);
		}
		
		List<Product> productList =  Database.getCurrentSession().createQuery("FROM Product").list();
		List<Category> categoryList =  Database.getCurrentSession().createQuery("FROM Category").list();
		for(Product product : productList)
		{
			for(Category category : categoryList)
			{
				ProductCategory productCategory = new ProductCategory();
				productCategory.setProduct(product);
				productCategory.setCategory(category);
				Database.getCurrentSession().save(productCategory);
			}
		}
		
		List<Label> labelList =  Database.getCurrentSession().createQuery("FROM Label").list();
		for(Product product : productList)
		{
			for(Label label : labelList)
			{
				ProductLabel productLabel = new ProductLabel();
				productLabel.setProduct(product);
				productLabel.setLabel(label);
				Database.getCurrentSession().save(productLabel);
			}
		}
		
		int size = productList.size() / 2;
		for (int index = 0; index < size; index++)
		{
			ProductRelated productRelated = new ProductRelated();
			productRelated.setProduct(productList.get(index));
			productRelated.setRelated(productList.get(index + size));
			Database.getCurrentSession().save(productRelated);
		}
		
		for (int index = 1; index < 10; index++)
		{
			Section section = new Section();
			section.setName("Name" + index);
			section.setOrder(index);
			if (index % 3 == 0)
			{
				section.setState(Section.STATE_AVAILABLE);
			}
			else if (index % 3 == 1)
			{
				section.setState(Section.STATE_DELETED);
			}
			else
			{
				section.setState(Section.STATE_DRAFT);
			}
			section.setVisible(index % 2 == 0 ? Boolean.TRUE : Boolean.FALSE);
			Database.getCurrentSession().save(section);
		}

		List<Section> sectionList =  Database.getCurrentSession().createQuery("FROM Section").list();
		for(Section section : sectionList)
		{
			for (Category category : categoryList)
			{
				SectionCategory sectionCategory = new SectionCategory();
				sectionCategory.setSection(section);
				sectionCategory.setCategory(category);
				Database.getCurrentSession().save(sectionCategory);
			}
		}

		for(Section section : sectionList)
		{
			for (Label label : labelList)
			{
				SectionLabel sectionLabel = new SectionLabel();
				sectionLabel.setLabel(label);
				sectionLabel.setSection(section);
				Database.getCurrentSession().save(sectionLabel);
			}
		}

		for(Section section : sectionList)
		{
			for (Product product : productList)
			{
				SectionProduct sectionProduct = new SectionProduct();
				sectionProduct.setProduct(product);
				sectionProduct.setSection(section);
				Database.getCurrentSession().save(sectionProduct);
			}
		}

//		System.out.println(
//				Database.getCurrentSession()
//					.createQuery("FROM Access")
//					.list()
//					);
//		
//		System.out.println(
//				Database.getCurrentSession()
//					.createQuery("FROM Alert")
//					.list()
//					);
//		
//		System.out.println(
//				Database.getCurrentSession()
//					.createQuery("FROM AlertUser")
//					.list()
//				);
//		
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM Category")
//				.list()
//				);
//
//	
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM Configuration")
//				.list()
//				);
//
//	
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM CurrencyExchange")
//				.list()
//				);
//
//	
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM Label")
//				.list()
//				);
//
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM Product")
//				.list()
//				);
//
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM ProductCategory")
//				.list()
//				);
//
//
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM ProductLabel")
//				.list()
//				);
//
//
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM ProductRelated")
//				.list()
//				);
//
//
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM Section")
//				.list()
//				);
//
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM SectionCategory")
//				.list()
//				);
//
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM SectionLabel")
//				.list()
//				);
//
//	System.out.println(
//			Database.getCurrentSession()
//				.createQuery("FROM SectionProduct")
//				.list()
//				);

//		User user = new User();
//		user.setUsername("augustosoncini" + System.currentTimeMillis());
//		user.setPassword("augustosoncini" + System.currentTimeMillis());
//		Database.getCurrentSession().save(user);
//		
//		List<User> userList = Database.getCurrentSession().createQuery("FROM User").list();
//		System.out.println(userList);
//		
//		user = userList.get(0);
//		user.setPassword("password" + System.currentTimeMillis());
//		Database.getCurrentSession().saveOrUpdate(user);
		
//		System.out.println(
//				Database.getCurrentSession()
//					.createQuery("FROM User")
//					.list()
//					);
//		
//		System.out.println(
//				Database.getCurrentSession()
//					.createQuery("FROM UserAccess")
//					.list()
//					);
//		
//		System.out.println(
//				Database.getCurrentSession()
//					.createQuery("FROM AlertUser")
//					.list()
//					);
//		
//		System.out.println(
//				Database.getCurrentSession()
//					.createQuery("FROM Category")
//					.list()
//					);
	}
}
