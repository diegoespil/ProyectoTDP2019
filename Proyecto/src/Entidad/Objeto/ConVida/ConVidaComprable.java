package Entidad.Objeto.ConVida;

public class ConVidaComprable extends ConVida {

	protected int precio;
	
	public ConVidaComprable(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public ConVidaComprable(int x, int y, int pre){
		super(x,y);
		precio = pre;
	}

	public int getPrecio(){
		return precio;
	}
	
}
