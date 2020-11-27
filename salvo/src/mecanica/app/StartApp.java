package mecanica.app;

import java.beans.Visibility;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JWindow;

import mecanica.frame.MecanicaFrame;

public class StartApp {
	

	public static void main(String[] args) throws SQLException {
		MecanicaFrame frame = new MecanicaFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.show();
		//frame.setVisible(true);
		//Splash frame = new Splash();
		//frame.splashInit();
		//frame.splashProgress(10000);
	}
	
}

