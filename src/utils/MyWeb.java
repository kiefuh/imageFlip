package utils;

import java.awt.Desktop;
import java.net.URI;

public class MyWeb {
	public static final String KLEISTER_GITHUB = "https://github.com/kiefuh";
	public static final String CAMPOS_GITHUB = "https://github.com/Camposm97";
	
	public static void open(String url) {
		try {
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(new URI(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
