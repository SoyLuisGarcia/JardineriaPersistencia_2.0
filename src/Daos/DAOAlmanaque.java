/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.util.List;
import java.util.Iterator;
import Connector.Connector;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;

/**
 *
 * @author claud
 */
public class DAOAlmanaque {

    private static SessionFactory factory = Connector.getConectionActual();

    public Integer addAlmanaque(Integer id_almanaque, Integer id_planta, String fecha_foto, String foto) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer daoID = null;
        try {
            tx = session.beginTransaction();
            Almanaque dao = new Almanaque(id_planta, id_almanaque, fecha_foto, foto);
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

    public void listAlmanaque() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List registro = session.createQuery("FROM Almanaque").list();
            for (Iterator iterator = registro.iterator(); iterator.hasNext();) {
                Almanaque dao = (Almanaque) iterator.next();
                System.out.println("ID Planta:" + dao.getId_planta());
                System.out.println("ID Registro: " + dao.getId_almanaque());
                System.out.println("Fecha de la Foto: " + dao.getFecha_foto());
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

    public void updateAlmanaqueFechaFoto(Integer id_almanaque, String fecha_foto) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Almanaque dao = (Almanaque) session.get(Almanaque.class, id_almanaque);
            dao.setFecha_foto(fecha_foto);
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

    public void updateAlmanaqueURLFoto(Integer id_almanaque, String foto) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Almanaque dao = (Almanaque) session.get(Almanaque.class, id_almanaque);
            dao.setFecha_foto(foto);
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

    public void deleteAlmanaque(Integer id_almanaque) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Almanaque dao = (Almanaque) session.get(Almanaque.class, id_almanaque);
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
