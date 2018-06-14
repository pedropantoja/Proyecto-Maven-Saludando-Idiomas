package com.huerta.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.huerta.model.Saludo;


@ManagedBean(name="obj")
@ViewScoped
public class ViewManager implements Serializable{
  private String nombre;
  private String respuesta;
  private int numSaludo;
  private boolean deboMostrar;
  private List<Saludo> listes;
  private List<Saludo> listen;
  private List<Saludo> listfr;
  private List<Saludo> todos = null;

  public ViewManager() {
    numSaludo = 0;
    respuesta = "";
    deboMostrar = false;
    listes = new ArrayList<Saludo>();
    listfr = new ArrayList<Saludo>();
    listen = new ArrayList<Saludo>();
  }
  public List<Saludo> getTodos() {
    return todos;
  }

  public boolean getDeboMostrar() {
     return deboMostrar;
  }
  public String getNombre() {
    return nombre;
  }

  public String getRespuesta() {
    return respuesta;
  }

  public void setNumSaludo(int valor) {
    this.numSaludo = valor;
  }

  public int getNumSaludo() {
    return numSaludo;
  }

  public void setRespuesta(String resp) {
    this.respuesta = resp;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void doListener(ActionEvent ac) {
    System.out.println("*** " + this.nombre + " ****");
  }

  public String cambiar() {
    return "index5";
  }
  public void doMostrar() {
    deboMostrar = true;
    todos = new ArrayList<Saludo>();
    todos.addAll(listes);
    todos.addAll(listen);
    todos.addAll(listfr);
  }
  public void doSomeThing(String lang) {
    deboMostrar = false;
    String veces = " veces";
    String veces_en = " times";
    this.numSaludo++;
    if(lang.equals("es")) {
      this.respuesta = "Hola " +  this.nombre + " ... he saludado " + this.numSaludo;
      listes.add(new Saludo(this.nombre,"es"));
    }
    if(lang.equals("en")) {
      this.respuesta = "Hi " +  this.nombre + " ... I greeted " + this.numSaludo + " times";
      listen.add(new Saludo(this.nombre,"en"));
    }
    if(lang.equals("fr")) {
      this.respuesta = "Salut " +  this.nombre + " ... j'ai salué " + this.numSaludo + " fois";
      listfr.add(new Saludo(this.nombre,"fr"));
    }
    if(numSaludo > 1 && lang.equals("es")){
      this.respuesta = this.respuesta + " veces";
    }
    if(numSaludo == 1 && lang.equals("es")){
      this.respuesta = this.respuesta + " vez";
    }
    this.nombre="";
  }
}
