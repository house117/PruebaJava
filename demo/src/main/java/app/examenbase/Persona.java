package app.examenbase;

public class Persona {
	private String nombre ="";
	private Integer edad = 0;
	private String NSS;
	private final Character SEXO;
	private Double pesoEnKg;
	private Double alturaEnMts;
	
	
	
	
	public Persona(String nombre, Integer edad, Character sexo, Double pesoEnKg, Double alturaEnMts) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		SEXO = sexo;
		this.pesoEnKg = pesoEnKg;
		this.alturaEnMts = alturaEnMts;
		this.NSS = this.generaNSS();
	}

	//Functions
	public Integer calcularIMC() {
		/* Al ser SEXO final, siempre será hombre, sin embargo
		 * se realizó el método de tal forma que también pudiese ser mujer.
		 */
		System.out.println((this.pesoEnKg/(Math.pow(this.alturaEnMts, 2))));
		Double imc = (this.pesoEnKg/(Math.pow(this.alturaEnMts, 2)));
		final Integer res;
		//Se regresará un objeto integer que no puede ser reasignado.
		if(this.SEXO.equals('H')) {
			System.out.println("Es hombre");
			if(imc < 20) {
				res = 1;
				return res;
			}else if(imc >=20 && imc<=25) {
				res = 0;
				return res;
			}else {
				res = 1;
				return res;
			}
		}else {
			if(imc < 19) {
				res = -1;
				return res;
			}else if(imc >=19 && imc<=24) {
				res = 0;
				return res;
			}else {
				res = 1;
				return res;
			}
		}
	}
	
	public Boolean esMayorDeEdad() {
		Boolean respuesta = (this.edad > 18)? true:  false;
		return respuesta;
	}
	@Override
	public String toString() {

		String cadena = "nombre: "+this.nombre+"<br>\n"+
				"edad: "+this.edad+"<br>\n"+
				"NSS: "+this.NSS+"<br>\n"+
				"SEXO: "+this.SEXO+"<br>\n"+
				"pesoEnKg: "+this.pesoEnKg+"<br>\n"+
				"alturaEnMts" +this.alturaEnMts;
		return cadena;
	}
	private String generaNSS() {
		String cadena = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
		StringBuilder retorno = new StringBuilder();
		
		for(int i = 0 ; i<8; i++) {
			int seleccionado = (int)(Math.random()*cadena.length());
			retorno.append(cadena.charAt(seleccionado));
		}
		return retorno.toString();
	}
	
	//Getters and setters

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	public void setPeso(Double peso) {
		this.pesoEnKg = peso;
	}
	public void setAltura(Double altura) {
		this.alturaEnMts = altura;
	}
	
	
	
	
}
