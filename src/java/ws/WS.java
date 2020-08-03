/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import alumno.Alumno;
import alumno.AlumnoImpl;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Acer
 */
@WebService(serviceName = "WS")
public class WS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getEgresados")
    public ArrayList<Alumno> getEgresados(@WebParam(name = "name") String codigo) throws Exception{
        alumno.AlumnoImpl am = new AlumnoImpl();
        return am.listEgresados(codigo);
    }
}
