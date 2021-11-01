package com.stegan.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.stegan.hibernate.dto.ImageMetaData;
import com.stegan.hibernate.dto.Key;

public class ImageSteganHibernateMain {

	public static void main(String args[]) {
		ImageMetaData imageDetails = new ImageMetaData();
		//imageDetails.setFileId(1);
		imageDetails.setName("Apple.jpg");
		imageDetails.setAddedBy("Ankit");
		imageDetails.setFileSize(450);
		imageDetails.setCreatedDate(new Date());
		
		ImageMetaData imageDetails2 = new ImageMetaData();
		//imageDetails.setFileId(2);
		imageDetails2.setName("Orange.jpg");
		imageDetails2.setAddedBy("Singh");
		imageDetails2.setFileSize(50);
		imageDetails2.setCreatedDate(new Date());

		Key key = new Key();
		key.setPrivateKey("testing private1");
		key.setPublicKey("testing public1");
		imageDetails.setKey(key);
		imageDetails2.setKey(key);
		Key key2 = new Key();
		key2.setPrivateKey("testing private2");
		key2.setPublicKey("testing public2");

		List<Key> keyList = new ArrayList<>();
		keyList.add(key);
		keyList.add(key2);
		imageDetails.setListKeys(keyList);
		imageDetails2.setListKeys(keyList);
		
		
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
