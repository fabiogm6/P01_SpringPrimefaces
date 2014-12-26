package br.com.spring.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.spring.model.Customer;

/**
 *
 * customer DAO
 *
 * @author uday
 * @since 19 Nov 2013
 * @version 1.0.0
 *
 */
@Repository
public class CustomerDAO  {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Get Hibernate Session Factory
     *
     * @return SessionFactory - Hibernate Session Factory
     */
    public SessionFactory getSessionFactory() {
    	System.out.println(">> CustomerDAO -> getSessionFactory");
        return sessionFactory;
    }

    /**
     * Set Hibernate Session Factory
     *
     * @param sessionFactory SessionFactory - Hibernate Session Factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
    	System.out.println(">> CustomerDAO -> setSessionFactory");
        this.sessionFactory = sessionFactory;
    }

    /**
     * Add customer
     *
     * @param   customer   customer
     */

    public void addCustomer(Customer customer) {
    	System.out.println(">> CustomerDAO -> addCustomer");
        getSessionFactory().getCurrentSession().save(customer);
    }

    /**
     * Delete customer
     *
     * @param   customer  customer
     */

    public void deleteCustomer(Customer customer) {
    	System.out.println(">> CustomerDAO -> deleteCustomer");
        getSessionFactory().getCurrentSession().delete(customer);
    }

    /**
     * Update customer
     *
     * @param  customer customer
     */

    public void updateCustomer(Customer customer) {
    	System.out.println(">> CustomerDAO -> updateCustomer");
        getSessionFactory().getCurrentSession().update(customer);
    }

    /**
     * Get customer
     *
     * @param  id int
     * @return customer
     */

    public Customer getCustomerById(int id) {
    	System.out.println(">> CustomerDAO -> getCustomerById");
        List list = getSessionFactory().getCurrentSession()
                                            .createQuery("from Customer  where id=?")
                                            .setParameter(0, id).list();
        return (Customer)list.get(0);
    }

    /**
     * Get customer List
     *
     * @return List - customer list
     */

    public List<Customer> getCustomers() {
    	System.out.println(">> CustomerDAO -> getCustomers");
        List list = getSessionFactory().getCurrentSession().createQuery("from  Customer").list();
        return list;
    }

}
