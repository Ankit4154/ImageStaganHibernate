package com.stegan.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.stegan.hibernate.dto.ImageMetaData;

public class ImageSteganHibernateMain {
	
	public static void main(String args[]) {
		ImageMetaData imageDetails = new ImageMetaData();
		imageDetails.setFileId(1);
		imageDetails.setName("Apple.jpg");
		imageDetails.setAddedBy("Ankit");
		imageDetails.setFileSize(450);
		imageDetails.setCreatedDate(new Date());
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(imageDetails);
		session.getTransaction().commit();
	}

}
