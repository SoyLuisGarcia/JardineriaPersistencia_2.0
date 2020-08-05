/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Connector.Connector;
import java.util.List;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;

/**
 *
 * @author claud
 */
public class DAORiego {

    private static SessionFactory factory = Connector.getConectionActual();

    public Integer addRiego(Integer id_planta, Integer id_riego, String fecha_riego) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer daoID = null;
        try {
            tx = session.beginTransaction();
            Riego dao = new Riego(id_planta, id_riego, fecha_riego);
            daoID = (Integer) session.save(dao);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return daoID;
    }

    public void listRiegos() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List riegos = session.createQuery("FROM Riego").list();
            for (Iterator iterator = riegos.iterator(); iterator.hasNext();) {
                Riego dao = (Riego) iterator.next();
                System.out.print("Id riego:" + dao.getId_riego());
                System.out.print("id planta: " + dao.getId_planta());
                System.out.println("Fecha del Riego: " + dao.getFecha_riego());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    /* Actualiza la edad */
    public void updateRiego(Integer id_riego, String fecha_riego) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Riego dao = (Riego) session.get(Riego.class, id_riego);
            dao.setFecha_riego(fecha_riego);
            session.update(dao);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void deleteRiego(Integer id_riego) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Riego dao = (Riego) session.get(Riego.class, id_riego);
            session.delete(dao);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
