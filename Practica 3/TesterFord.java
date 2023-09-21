/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

public class TesterFord {
	public static void main(String[] args){
		AutomovilFord auto = new AutomovilFord();
		auto.encenderMotor();
		System.out.println("El auto " + auto.marca + " " + auto.modelo + " " + auto.color + " ha sido creado!");
		while(auto.getVelocidad () < 200){
			auto.acelerar();
		}
		auto.frenar(6000);
	}
}
