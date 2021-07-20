package com.fundamentospringboot.platziSpringBoot.bean;

import java.util.Date;
import java.util.Calendar;

public class MyOwnImplement implements MyOwn{

    @Override
    public void saludar(String nombre, Date fechaNacimiento) {
        int edad = calcularEdad(fechaNacimiento);
        System.out.println("Hola "+nombre+", su edad es "+ edad+" años");
    }


    public static Integer calcularEdad(Date fechaNac){
        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        fechaNacimiento.setTime(fechaNac);
        //Se restan la fecha actual y la fecha de nacimiento
        int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
        //Se ajusta el año dependiendo el mes y el día
        if(mes<0 || (mes==0 && dia<0)){
            año--;
        }
        //Regresa la edad en base a la fecha de nacimiento
        return año;
    }

}
