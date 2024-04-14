package it.ecommerce.bookshop.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ITConstants {
	
	public final static String IT = "IT";
	
	public final static Map<String, String> mapOfItStates = new HashMap<>() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("M'bazie", "M'bazie");
		}
	};
	
	public final static List<String> lisOfStatesCode = new ArrayList<>(mapOfItStates.keySet());
	public final static List<String> lisOfStatesName = new ArrayList<>(mapOfItStates.values());
	
}