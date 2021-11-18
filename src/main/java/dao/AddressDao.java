package dao;

import javax.persistence.EntityManager;

import database.DatabaseConnection;
import entity.Address;

public class AddressDao {

    public Address find(int id) {
        EntityManager entityManager = DatabaseConnection.getInstance().getConnection();
        Address address = entityManager.find(Address.class, id);
        entityManager.close();
        return address;
    }

    public Address insertOrUpdate(Address address) {
        EntityManager entityManager = DatabaseConnection.getInstance().getConnection();

        entityManager.getTransaction().begin();
        Address newAddress = entityManager.merge(address);
        entityManager.getTransaction().commit();
        entityManager.close();

        return newAddress;
    }

    public void delete(Address address) {
        EntityManager entityManager = DatabaseConnection.getInstance().getConnection();
        entityManager.getTransaction().begin();

        address = entityManager.merge(address);
        entityManager.remove(address);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
