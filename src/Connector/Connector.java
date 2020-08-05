/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

/**
 *
 * @author claud
 */
import org.hibernate.SessionFactory;
public class Connector {
	public static SessionFactory conecActual=null;
	
	public static void setConeccionActual(SessionFactory conect) {
		conecActual=conect; 
	}
	
	public static SessionFactory getConectionActual() {
		return conecActual;
	}
}
