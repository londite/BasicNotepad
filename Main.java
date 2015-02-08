/* Open source Basic notepad as a java testing
 *  Created by Jose Garcia on November 10, 2013
 *  
 *  Description
 *      This small java application is a basic notepad that can open, save and edit txt files.
 *
 *  Licese: Open source Basic notepad by Jose Garcia is licensed under a Creative Commons BY-NC-SA (Attribution-NonCommercial-ShareAlike) 3.0 Unported License.
 * 
 */

import javax.swing.JFrame;
 
public class Main {
	public static void main(String args[]){
		JFrame frame = new Editor();
		frame.setTitle("Basic notepad");
		frame.setVisible(true);
		frame.setSize(800, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
	}
}
