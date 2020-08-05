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
public class DAOTipos {

    private static SessionFactory factory = Connector.getConectionActual();

    public Integer addTipo(Integer id_tipo, String tipo, String nombre_tipo) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer daoID = null;
        try {
            tx = session.beginTransaction();
            Tipos dao = new Tipos(id_tipo, tipo, nombre_tipo);
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

    public void listTipos() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List tipos = session.createQuery("FROM Tipo").list();
            for (Iterator iterator = tipos.iterator(); iterator.hasNext();) {
                Tipos dao = (Tipos) iterator.next();
                System.out.println("Id de tipo:" + dao.getId_tipo());
                System.out.println("Id de la planta: " + dao.getId_planta());
                System.out.println("Tipo registrado" + dao.getTipo());
                System.out.println("Nombre del Tipo" + dao.getNombre_tipo());
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

    public void updateTipo(Integer id_tipo, String tipo) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Tipos dao = (Tipos) session.get(Tipos.class, id_tipo);
            dao.setTipo(tipo);
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

    public void updateNombreTipo(Integer id_tipo, String nombre_tipo) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Tipos dao = (Tipos) session.get(Tipos.class, id_tipo);
            dao.setNombre_tipo(nombre_tipo);
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

    public void deleteTipo(Integer id_tipo) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Tipos dao = (Tipos) session.get(Tipos.class, id_tipo);
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

    public void updateAll(Integer id_tipo, String tipo, String nombre_tipo) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Tipos dao = (Tipos) session.get(Productos.class, id_tipo);
            dao.setNombre_tipo(nombre_tipo);
            dao.setTipo(tipo);
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

    public ObservableList traerlistTipos() {
        ObservableList<DAOTipos.Person> lista = FXCollections.observableArrayList();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List Pro = session.createQuery(" from Tipos").list();
            for (Iterator iterator = Pro.iterator(); iterator.hasNext();) {
                DAOTipos.Person person;
                Tipos dao = (Tipos) iterator.next();
                System.out.println("Id de la planta" + dao.getId_planta());
                System.out.println("id del tipo:" + dao.getId_tipo());
                System.out.println("Tipo de la planta: " + dao.getTipo());
                System.out.println("Descripcion: " + dao.getNombre_tipo());
                person = new DAOTipos.Person(String.valueOf(dao.getId_planta()), String.valueOf(dao.getId_tipo()), dao.getTipo(), dao.getNombre_tipo());
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
        ObservableList<DAOTipos.Person> lista = FXCollections.observableArrayList();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List Pro = session.createQuery(" from Tipos group_by nombre_planta").list();
            for (Iterator iterator = Pro.iterator(); iterator.hasNext();) {
                DAOTipos.Person person;
                Tipos dao = (Tipos) iterator.next();
                System.out.println("Id de la planta" + dao.getId_planta());
                System.out.println("Nombre Planta:" + dao.getId_tipo());
                System.out.println("fecha de ingreso de la Planta: " + dao.getTipo());
                System.out.println("Estado de la Planta: " + dao.getNombre_tipo());
                person = new DAOTipos.Person(String.valueOf(dao.getId_planta()), String.valueOf(dao.getId_tipo()), dao.getTipo(), dao.getNombre_tipo());
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
