package com.stegan.hibernate;

import java.util.Date;
import javax.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.stegan.hibernate.dto.ImageMetaData;

public class ImageSteganHibernateMain {

	public static void main(String args[]) {
		ImageMetaData imageDetails = new ImageMetaData();
		//imageDetails.setFileId(1);
		imageDetails.setName("Apple.jpg");
		imageDetails.setAddedBy("Ankit");
		imageDetails.setFileSize(450);
		imageDetails.setCreatedDate(new Date());
		
		ImageMetaData imageDetails2 = new ImageMetaData();
		imageDetails2.setName("Orange.jpg");
		imageDetails2.setAddedBy("Singh");
		imageDetails2.setFileSize(50);
		imageDetails2.setCreatedDate(new Date());

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(imageDetails);
			session.save(imageDetails2);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			System.out.println("PersistenceException caught " + e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		/*
		imageDetails = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		imageDetails = (ImageMetaData) session.get(ImageMetaData.class, 1);
		System.out.println("File ID retrieved is :" + imageDetails.getFileId());
		*/
	}

}
