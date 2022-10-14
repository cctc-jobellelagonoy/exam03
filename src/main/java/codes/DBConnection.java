package codes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DBConnection {
	EntityManagerFactory userFactoryObj;
	EntityManager entity;
	
	public DBConnection(){
		userFactoryObj = Persistence.createEntityManagerFactory("JPADemo");
		entity = userFactoryObj.createEntityManager();
	}
	
	public User insertUser(String username, String password, String firstname, String lastname, String type) {
		User s = new User(username, password, firstname, lastname, type);
		entity.getTransaction().begin();
		entity.persist(s);
		entity.getTransaction().commit();
		
		return s;
	}
	

	public User findUser(String username, String password) {
		entity = userFactoryObj.createEntityManager();
		entity.getTransaction().begin();
		User user = (User) entity.createQuery("select c from User c where c.username = :un and c.password = :pw")
				.setParameter("un", username)
				.setParameter("pw", password)
			    .getResultList().get(0);
		return user;
	}
	
	public List<User> getUsers() {
		entity = userFactoryObj.createEntityManager();
		entity.getTransaction().begin();
		List<User> users = (List<User>) entity.createQuery("select c from User c")
			    .getResultList();
		return users;
	}
}
