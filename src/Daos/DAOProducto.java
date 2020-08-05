/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Connector.Connector;
import java.util.List;
import java.util.Iterator;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;

/**
 *
 * @author claud
 */
public class DAOProducto {

    private static SessionFactory factory = Connector.getConectionActual();

    public Integer addProducto(String nombre_planta, String fecha_ingreso, String status) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer daoID = null;
        try {
            tx = session.beginTransaction();
            Productos dao = new Productos(nombre_planta, fecha_ingreso, status);
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

    public void listProductos() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List producto = session.createQuery("FROM Productos").list();
            for (Iterator iterator = producto.iterator(); iterator.hasNext();) {
                Productos dao = (Productos) iterator.next();
                System.out.println("Id de la planta" + dao.getId());
                System.out.println("Nombre Planta:" + dao.getNombre_planta());
                System.out.println("Fecha de Ingreso: " + dao.getFecha_ingreso());
                System.out.println("Estado de la Planta: " + dao.getStatus());
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

    public void updateProductoNombre(Integer id, String nombre_planta) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Productos dao = (Productos) session.get(Productos.class, id);
            dao.setNombre_planta(nombre_planta);
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

    public void updateProductoIngreso(Integer id, String fecha_ingreso) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Productos dao = (Productos) session.get(Productos.class, id);
            dao.setFecha_ingreso(fecha_ingreso);
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

    public void deleteAlumno(Integer id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Productos dao = (Productos) session.get(Productos.class, id);
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

    public void updateAll(Integer id, String fecha_ingreso, String nombre_planta, String status) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Productos dao = (Productos) session.get(Productos.class, id);
            dao.setFecha_ingreso(fecha_ingreso);
            dao.setNombre_planta(nombre_planta);
            dao.setStatus(status);
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

    public ObservableList traerlistProductos() {
        ObservableList<Person> lista = FXCollections.observableArrayList();
        factory = Connector.getConectionActual();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List Pro = session.createQuery(" from Productos").list();
            for (Iterator iterator = Pro.iterator(); iterator.hasNext();) {
                Person person;
                Productos dao = (Productos) iterator.next();
                System.out.println("Id de la planta" + dao.getId());
                System.out.println("Nombre Planta:" + dao.getNombre_planta());
                System.out.println("fecha de ingreso de la Planta: " + dao.getFecha_ingreso());
                System.out.println("Estado de la Planta: " + dao.getStatus());
                person = new Person(String.valueOf(dao.getId()), dao.getNombre_planta(), dao.getFecha_ingreso(), dao.getStatus());

                lista.add(person);
            }
            tx.commit();
            return lista;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return lista;
    }

    public ObservableList traergrafica() {
        ObservableList<Person> lista = FXCollections.observableArrayList();
        factory = Connector.getConectionActual();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List Pro = session.createQuery(" from Productos group_by nombre_planta").list();
            for (Iterator iterator = Pro.iterator(); iterator.hasNext();) {
                Person person;
                Productos dao = (Productos) iterator.next();
                System.out.println("Id de la planta" + dao.getId());
                System.out.println("Nombre Planta:" + dao.getNombre_planta());
                System.out.println("fecha de ingreso de la Planta: " + dao.getFecha_ingreso());
                System.out.println("Estado de la Planta: " + dao.getStatus());
                person = new Person(String.valueOf(dao.getId()), dao.getNombre_planta(), dao.getFecha_ingreso(), dao.getStatus());

                lista.add(person);
            }
            tx.commit();
            return lista;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return lista;
    }

    public static class Person {

        private final SimpleStringProperty primerNombre;
        private final SimpleStringProperty segundoNombre;
        private final SimpleStringProperty email;
        private final SimpleStringProperty cuarto;

        private Person(String fName, String lName, String emailq, String cua) {

            this.primerNombre = new SimpleStringProperty(fName);
            this.segundoNombre = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(emailq);
            this.cuarto = new SimpleStringProperty(cua);
        }

        public String getPrimerNombre() {
            return primerNombre.get();
        }

        public void setPrimerNombre(String fName) {
            primerNombre.set(fName);
        }

        public void setCuarto(String fName) {
            cuarto.set(fName);
        }

        public String getCuarto() {
            return cuarto.get();
        }

        public String getSegundoNombre() {
            return segundoNombre.get();
        }

        public void setSegundoNombre(String lName) {
            segundoNombre.set(lName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String emailq) {
            email.set(emailq);
        }
    }
}
