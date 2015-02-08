import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
 
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Editor extends JFrame{
	/*
	 * See notes in Main.java 
	 */
	private static final long serialVersionUID = 1L;
	int fileToOpen;
	int fileToSave;
	JFileChooser fileOpen;
	JFileChooser fileSave;
	Editor(){
		MenuBar menuBar = new MenuBar();
		final JTextArea textArea = new JTextArea();
		setMenuBar(menuBar);
		Menu file = new Menu("File");
		menuBar.add(file);
		Menu quit = new Menu("Exit");
		menuBar.add(quit);
		MenuItem newOption = new MenuItem("New");
		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		file.add(newOption);
		file.add(open);
		file.add(save);
		getContentPane().add(textArea);
 
		newOption.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textArea.setText("");
			}
		});
 
		open.addActionListener(new ActionListener(){
			private Scanner scan;

			public void actionPerformed(ActionEvent e){
				openFile();
				if (fileToOpen == JFileChooser.APPROVE_OPTION){
					textArea.setText("");
					try{
						scan = new Scanner(new FileReader(fileOpen.getSelectedFile().getPath()));
						while (scan.hasNext())
							textArea.append(scan.nextLine());
					} catch (Exception ex){
						System.out.println(ex.getMessage());
					}
				}
			}
		});
 
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveFile();
				if (fileToSave == JFileChooser.APPROVE_OPTION){
					try {
						BufferedWriter out = new BufferedWriter(new FileWriter(fileSave.getSelectedFile().getPath()));
						out.write(textArea.getText());
						out.close();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		});
 
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
	
	public void openFile(){
		JFileChooser open = new JFileChooser();
		int option = open.showOpenDialog(this);
		fileToOpen = option;
		fileOpen = open;
	}
 
	public void saveFile(){
		JFileChooser save = new JFileChooser();
		int option = save.showOpenDialog(this);
		fileToSave = option;
		fileSave = save;
	}
}
