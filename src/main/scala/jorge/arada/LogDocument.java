package jorge.arada;

import java.io.Serializable;
import java.util.HashMap;

public class LogDocument implements Serializable {
	public final String Message;
	public final java.util.HashMap<String, Object> Data;


	public LogDocument(String message, HashMap<String, Object> data) {
		this.Message = message;
		this.Data = data;
	}


}
