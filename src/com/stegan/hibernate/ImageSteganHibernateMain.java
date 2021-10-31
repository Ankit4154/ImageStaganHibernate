package com.stegan.hibernate;

import java.sql.SQLException;
import java.util.Date;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;

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
		try {
			session.beginTransaction();
			session.save(imageDetails);
			session.getTransaction().commit();
		}catch(ConstraintViolationException e) {
			System.out.println("ConstraintViolationException caught "+e);
			session.getTransaction().rollback();
		}catch(PersistenceException e) {
			System.out.println("PersistenceException caught "+e);
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		
	}

}
