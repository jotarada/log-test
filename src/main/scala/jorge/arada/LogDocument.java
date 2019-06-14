package jorge.arada;

import java.io.Serializable;
import java.util.HashMap;

public class Teste implements Serializable {
	public final String Message;
	public final java.util.HashMap<String, Object> Data;


	public Teste(String message, HashMap<String, Object> data) {
		this.Message = message;
		this.Data = data;
	}


}
