import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;
//import javafx.scene.media.AudioClip;
import java.net.*;

public class ToneMatrix extends JPanel implements ActionListener, Runnable, MouseListener
{
	JFrame frame;
	JToggleButton[][] notes;
	JPanel notePanel;
	JPanel topPanel;
	int rows;
	int cols;

	JButton reset;

	URL[] urls;
	AudioClip[] clips;

	boolean notStopped = true;

	JMenuBar menuBar;
	JMenu songs;
	JMenuItem song1;
	JMenuItem song2;
	JMenuItem song3;
	JMenu addremove;
	JMenuItem add;
	JMenuItem remove;
	JMenu saveload;
	JMenuItem save;
	JMenuItem load;
	Thread timing;

	ImageIcon black;

	int[][] songOneNotes;
	int[][] songTwoNotes;
	int[][] songThreeNotes;

	JLabel note1;
	JLabel note2;
	JLabel note3;
	JLabel note4;
	JLabel note5;
	JLabel note6;
	JLabel note7;
	JLabel note8;
	JLabel note9;
	JLabel note10;
	JLabel note11;
	JLabel note12;
	JLabel note13;
	JLabel note14;
	JLabel note15;
	JLabel note16;
	JLabel note17;
	JLabel note18;
	JLabel note19;
	JLabel note20;
	JLabel note21;
	JLabel note22;
	JLabel note23;
	JLabel note24;
	JLabel note25;
	JLabel note26;
	JLabel note27;
	JLabel note28;
	JLabel note29;
	JLabel note30;

	public ToneMatrix()
	{
		frame = new JFrame();
		frame.add(this);
		frame.setSize(1000,1000);

		menuBar = new JMenuBar();
		songs = new JMenu("Pre-Built Songs");
		song1 = new JMenuItem("Binary Sunset");
		song1.addActionListener(this);
		song2 = new JMenuItem("Cantina Theme");
		song2.addActionListener(this);
		song3 = new JMenuItem("Zelda Theme");
		song3.addActionListener(this);
		addremove = new JMenu("Add/Remove Columns");
		add = new JMenuItem("Add");
		add.addActionListener(this);
		remove = new JMenuItem("Remove");
		remove.addActionListener(this);
		saveload = new JMenu("Save/Load Songs");
		save = new JMenuItem("Save");
		save.addActionListener(this);
		load = new JMenuItem("Load");
		load.addActionListener(this);

		reset = new JButton("Reset");
		reset.addActionListener(this);

		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(30,1));

		note1 = new JLabel("E6");
		note2 = new JLabel("D6");
		note3 = new JLabel("C6");
		note4 = new JLabel("B5");
		note5 = new JLabel("A#5");
		note6 = new JLabel("A5");
		note7 = new JLabel("G#5");
		note8 = new JLabel("G5");
		note9 = new JLabel("F#5");
		note10 = new JLabel("F5");
		note11 = new JLabel("E5");
		note12 = new JLabel("D#5");
		note13 = new JLabel("D5");
		note14 = new JLabel("C#5");
		note15 = new JLabel("C5");
		note16 = new JLabel("B4");
		note17 = new JLabel("A#4");
		note18 = new JLabel("A4");
		note19 = new JLabel("G#4");
		note20 = new JLabel("G4");
		note21 = new JLabel("F#4");
		note22 = new JLabel("F4");
		note23 = new JLabel("E4");
		note24 = new JLabel("D4");
		note25 = new JLabel("C4");
		note26 = new JLabel("B3");
		note27 = new JLabel("A3");
		note28 = new JLabel("G3");
		note29 = new JLabel("D3");
		note30 = new JLabel("C3");

		topPanel.add(note1);
		topPanel.add(note2);
		topPanel.add(note3);
		topPanel.add(note4);
		topPanel.add(note5);
		topPanel.add(note6);
		topPanel.add(note7);
		topPanel.add(note8);
		topPanel.add(note9);
		topPanel.add(note10);
		topPanel.add(note11);
		topPanel.add(note12);
		topPanel.add(note13);
		topPanel.add(note14);
		topPanel.add(note15);
		topPanel.add(note16);
		topPanel.add(note17);
		topPanel.add(note18);
		topPanel.add(note19);
		topPanel.add(note20);
		topPanel.add(note21);
		topPanel.add(note22);
		topPanel.add(note23);
		topPanel.add(note24);
		topPanel.add(note25);
		topPanel.add(note26);
		topPanel.add(note27);
		topPanel.add(note28);
		topPanel.add(note29);
		topPanel.add(note30);

		songs.add(song1);
		songs.add(song2);
		songs.add(song3);
		menuBar.add(songs);
		addremove.add(add);
		addremove.add(remove);
		menuBar.add(addremove);
		saveload.add(save);
		saveload.add(load);
		menuBar.add(saveload);
		frame.add(topPanel,BorderLayout.WEST);
		frame.add(reset,BorderLayout.SOUTH);
		frame.add(menuBar,BorderLayout.NORTH);

		try
		{
			URL r1 = new URL("file:C3.wav");
			URL r2 = new URL("file:D3.wav");
			URL r3 = new URL("file:G3.wav");
			URL r4 = new URL("file:A3.wav");
			URL r5 = new URL("file:B3.wav");
			URL r6 = new URL("file:C4.wav");
			URL r7 = new URL("file:D4.wav");
			URL r8 = new URL("file:E4.wav");
			URL r9 = new URL("file:F4.wav");
			URL r10 = new URL("file:FSharp4.wav");
			URL r11 = new URL("file:G4.wav");
			URL r12 = new URL("file:GSharp4.wav");
			URL r13 = new URL("file:A4.wav");
			URL r14 = new URL("file:ASharp4.wav");
			URL r15 = new URL("file:B4.wav");
			URL r16 = new URL("file:C5.wav");
			URL r17 = new URL("file:CSharp5.wav");
			URL r18 = new URL("file:D5.wav");
			URL r19 = new URL("file:DSharp5.wav");
			URL r20 = new URL("file:E5.wav");
			URL r21 = new URL("file:F5.wav");
			URL r22 = new URL("file:FSharp5.wav");
			URL r23 = new URL("file:G5.wav");
			URL r24 = new URL("file:GSharp5.wav");
			URL r25 = new URL("file:A5.wav");
			URL r26 = new URL("file:ASharp5.wav");
			URL r27 = new URL("file:B5.wav");
			URL r28 = new URL("file:C6.wav");
			URL r29 = new URL("file:D6.wav");
			URL r30 = new URL("file:E6.wav");
			urls = new URL[]{r30,r29,r28,r27,r26,r25,r24,r23,r22,r21,r20,r19,r18,r17,r16,r15,r14,r13,r12,r11,r10,r9,r8,r7,r6,r5,r4,r3,r2,r1};
		}catch(MalformedURLException e)
		{
		}

		clips = new AudioClip[urls.length];

		for(int x = 0; x < urls.length; x++)
		{
			clips[x] = JApplet.newAudioClip(urls[x]);
		}

		black = new ImageIcon("black.png");

		rows = 30;
		cols = 30;
		notes = new JToggleButton[rows][cols];

		notePanel = new JPanel();
		notePanel.setLayout(new GridLayout(rows,cols,3,3));

		for(int x = 0; x < notes.length; x++)
		{
			for(int y = 0; y < notes[0].length; y++)
			{
				notes[x][y] = new JToggleButton();
				notes[x][y].setBackground(Color.WHITE);
				notes[x][y].setBorder(new LineBorder(Color.BLACK));
				notes[x][y].addMouseListener(this);
				notePanel.add(notes[x][y]);
			}
		}

		frame.add(notePanel,BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		timing = new Thread(this);
		timing.start();
	}

	public void mouseClicked(MouseEvent e)
	{

	}

	public void mouseReleased(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			for(int x = 0; x < notes.length; x++)
			{
				for(int y = 0; y < notes[0].length; y++)
				{
					if(e.getSource() == notes[x][y])
					{
						if(notes[x][y].isSelected())
						{
							notes[x][y].setIcon(black);
						}else
						{
							notes[x][y].setIcon(null);
						}
					}
				}
			}
		}
		for(int x = 0; x < notes.length; x++)
		{
			for(int y = 0; y < notes[0].length; y++)
			{
				if(e.getSource() == notes[x][y])
				{
					if(notes[x][y].isSelected())
					{
						notes[x][y].setIcon(black);
					}else
					{
						notes[x][y].setIcon(null);
					}
				}
			}
		}

	}

	public void mousePressed(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{

	}

	public void mouseExited(MouseEvent e)
	{

	}

	public void run()
	{
		do
		{
			try
			{
				for(int y = 0; y < notes[0].length; y++)
				{
					for(int x = 0; x < notes.length; x++)
					{
						if(notes[x][y]!=null && notes[x][y].isSelected())
						{
							notes[x][y].setBorder(new LineBorder(Color.RED,3));
							clips[x].stop();
							clips[x].play();
						}
					}
					timing.sleep(150);
					for(int x = 0; x < notes.length; x++)
					{
						if(notes[x][y]!=null)
						{
							notes[x][y].setBorder(new LineBorder(Color.BLACK));
						}
					}
				}
			}
			catch(InterruptedException e)
			{
			}
		}while(notStopped);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == add)
		{
			int[][] prevSongState = new int[rows][cols+1];
			for(int x = 0; x < prevSongState.length; x++)
			{
				for(int y = 0; y < prevSongState[0].length; y++)
				{
					if(y < prevSongState[0].length-1)
					{
						if(notes[x][y].isSelected())
						{
							prevSongState[x][y] = 1;
						}
					}
				}
			}
			frame.remove(notePanel);
			cols++;
			notes = new JToggleButton[rows][cols];
			notePanel = new JPanel();
			notePanel.setLayout(new GridLayout(rows,cols,3,3));
			for(int x = 0; x < notes.length; x++)
			{
				for(int y = 0; y < notes[0].length; y++)
				{
					notes[x][y] = new JToggleButton();
					notes[x][y].setBackground(Color.WHITE);
					notes[x][y].setBorder(new LineBorder(Color.BLACK));
					notes[x][y].addMouseListener(this);
					if(prevSongState[x][y] == 1)
					{
						notes[x][y].setSelected(true);
						notes[x][y].setIcon(black);
					}
					notePanel.add(notes[x][y]);
				}
			}
			frame.add(notePanel,BorderLayout.CENTER);
		}
		if(cols > 1)
		{
			if(e.getSource() == remove)
			{
				int[][] prevSongState = new int[rows][cols-1];
				for(int x = 0; x < prevSongState.length; x++)
				{
					for(int y = 0; y < prevSongState[0].length; y++)
					{
						if(notes[x][y].isSelected())
						{
							prevSongState[x][y] = 1;
						}
					}
				}
				frame.remove(notePanel);
				cols--;
				notes = new JToggleButton[rows][cols];
				notePanel = new JPanel();
				notePanel.setLayout(new GridLayout(rows,cols,5,5));
				for(int x = 0; x < notes.length; x++)
				{
					for(int y = 0; y < notes[0].length; y++)
					{
						notes[x][y] = new JToggleButton();
						notes[x][y].setBackground(Color.WHITE);
						notes[x][y].setBorder(new LineBorder(Color.BLACK));
						notes[x][y].addMouseListener(this);
						if(prevSongState[x][y] == 1)
						{
							notes[x][y].setSelected(true);
							notes[x][y].setIcon(black);
						}
						notePanel.add(notes[x][y]);
					}
				}
				frame.add(notePanel,BorderLayout.CENTER);
			}
		}
		if(e.getSource() == song1)
		{
			File bisun = new File("song1.txt");
			songOneNotes = null;

			try
			{
				BufferedReader input = new BufferedReader(new FileReader(bisun));
				String text = "";
				String[] line;
				int x = -2;
				while((text = input.readLine()) != null)
				{
					if(x == -2)
					{
						rows = Integer.parseInt(text);
					}
					if(x == -1)
					{
						cols = Integer.parseInt(text);
						songOneNotes = new int[rows][cols];
					}
					if(x >= 0)
					{
						line = text.split("");
						for(int i = 0; i < line.length; i++){
							songOneNotes[x][i] = Integer.parseInt(line[i]);
						}
						System.out.println();
					}
					x++;
				}
			}catch(Exception exception)
			{

			}

			for(int x = 0; x < songOneNotes.length; x++)
			{
				for(int y = 0; y < songOneNotes[0].length; y++)
				{
					System.out.print(songOneNotes[x][y]);
				}
				System.out.println();
			}
			frame.remove(notePanel);
			notes = new JToggleButton[rows][cols];
			notePanel = new JPanel();
			notePanel.setLayout(new GridLayout(rows,cols,3,3));
			for(int x = 0; x < notes.length; x++)
			{
				for(int y = 0; y < notes[0].length; y++)
				{
					notes[x][y] = new JToggleButton();
					notes[x][y].setBackground(Color.WHITE);
					notes[x][y].setBorder(new LineBorder(Color.BLACK));
					notes[x][y].addMouseListener(this);
					if(songOneNotes[x][y] == 1)
					{
						notes[x][y].setSelected(true);
						notes[x][y].setIcon(black);
					}
					notePanel.add(notes[x][y]);
				}
			}
			frame.add(notePanel,BorderLayout.CENTER);
		}
		if(e.getSource() == song2)
		{
			File cantina = new File("song2.txt");
			songTwoNotes = null;

			try
			{
				BufferedReader input = new BufferedReader(new FileReader(cantina));
				String text = "";
				String[] line;
				int x = -2;
				while((text = input.readLine()) != null)
				{
					if(x == -2)
					{
						rows = Integer.parseInt(text);
					}
					if(x == -1)
					{
						cols = Integer.parseInt(text);
						songTwoNotes = new int[rows][cols];
					}
					if(x >= 0)
					{
						line = text.split("");
						for(int i = 0; i < line.length; i++){
							songTwoNotes[x][i] = Integer.parseInt(line[i]);
						}
						System.out.println();
					}
					x++;
				}
			}catch(Exception exception)
			{

			}

			for(int x = 0; x < songTwoNotes.length; x++)
			{
				for(int y = 0; y < songTwoNotes[0].length; y++)
				{
					System.out.print(songTwoNotes[x][y]);
				}
				System.out.println();
			}
			frame.remove(notePanel);
			notes = new JToggleButton[rows][cols];
			notePanel = new JPanel();
			notePanel.setLayout(new GridLayout(rows,cols,3,3));
			for(int x = 0; x < notes.length; x++)
			{
				for(int y = 0; y < notes[0].length; y++)
				{
					notes[x][y] = new JToggleButton();
					notes[x][y].setBackground(Color.WHITE);
					notes[x][y].setBorder(new LineBorder(Color.BLACK));
					notes[x][y].addMouseListener(this);
					if(songTwoNotes[x][y] == 1)
					{
						notes[x][y].setSelected(true);
						notes[x][y].setIcon(black);
					}
					notePanel.add(notes[x][y]);
				}
			}
			frame.add(notePanel,BorderLayout.CENTER);
		}
		if(e.getSource() == song3)
		{
			File zelda = new File("song3.txt");
			songThreeNotes = null;

			try
			{
				BufferedReader input = new BufferedReader(new FileReader(zelda));
				String text = "";
				String[] line;
				int x = -2;
				while((text = input.readLine()) != null)
				{
					if(x == -2)
					{
						rows = Integer.parseInt(text);
					}
					if(x == -1)
					{
						cols = Integer.parseInt(text);
						songThreeNotes = new int[rows][cols];
					}
					if(x >= 0)
					{
						line = text.split("");
						for(int i = 0; i < line.length; i++){
							songThreeNotes[x][i] = Integer.parseInt(line[i]);
						}
						System.out.println();
					}
					x++;
				}
			}catch(Exception exception)
			{

			}

			frame.remove(notePanel);
			notes = new JToggleButton[rows][cols];
			notePanel = new JPanel();
			notePanel.setLayout(new GridLayout(rows,cols,3,3));
			for(int x = 0; x < notes.length; x++)
			{
				for(int y = 0; y < notes[0].length; y++)
				{
					notes[x][y] = new JToggleButton();
					notes[x][y].setBackground(Color.WHITE);
					notes[x][y].setBorder(new LineBorder(Color.BLACK));
					notes[x][y].addMouseListener(this);
					if(songThreeNotes[x][y] == 1)
					{
						notes[x][y].setSelected(true);
						notes[x][y].setIcon(black);
					}
					notePanel.add(notes[x][y]);
				}
			}
			frame.add(notePanel,BorderLayout.CENTER);
		}
		if(e.getSource() == save)
		{
			String fileName = JOptionPane.showInputDialog("Enter file name:");
			int[][] saveSongNotes = new int[rows][cols];
			for(int x = 0; x < saveSongNotes.length; x++)
			{
				for(int y = 0; y < saveSongNotes[0].length; y++)
				{
					if(notes[x][y].isSelected())
					{
						saveSongNotes[x][y] = 1;
					}
				}
			}
			for(int x = 0; x < saveSongNotes.length; x++)
			{
				for(int y = 0; y < saveSongNotes[0].length; y++)
				{
					System.out.print(saveSongNotes[x][y]);
				}
				System.out.println();
			}
			try
			{
				System.out.println("Saved");
				File file = new File(fileName+".txt");
				BufferedWriter out = new BufferedWriter(new FileWriter(file));
				out.write(rows+"\n"+cols+"\n");
				for(int x = 0; x < saveSongNotes.length; x++)
				{
					for(int y = 0; y < saveSongNotes[0].length; y++)
					{
						out.write(Integer.toString(saveSongNotes[x][y]));
					}
					out.write("\n");
				}
				out.close();
			}catch(IOException io)
			{
			}
		}
		if(e.getSource() == load)
		{
			int[][] loadSongNotes = null;
			String fileName = JOptionPane.showInputDialog("Enter file name:");
			File loadedSong = new File(fileName+".txt");

			try
			{
				BufferedReader input = new BufferedReader(new FileReader(loadedSong));
				String text = "";
				String[] line;
				int x = -2;
				while((text = input.readLine()) != null)
				{
					if(x == -2)
					{
						rows = Integer.parseInt(text);
					}
					if(x == -1)
					{
						cols = Integer.parseInt(text);
						loadSongNotes = new int[rows][cols];
					}
					if(x >= 0)
					{
						line = text.split("");
						for(int i = 0; i < line.length; i++){
							loadSongNotes[x][i] = Integer.parseInt(line[i]);
						}
						System.out.println();
					}
					x++;
				}
			}catch(Exception exception)
			{

			}

			for(int x = 0; x < loadSongNotes.length; x++)
			{
				for(int y = 0; y < loadSongNotes[0].length; y++)
				{
					System.out.print(loadSongNotes[x][y]);
				}
				System.out.println();
			}
			frame.remove(notePanel);
			notes = new JToggleButton[rows][cols];
			notePanel = new JPanel();
			notePanel.setLayout(new GridLayout(rows,cols,3,3));
			for(int x = 0; x < notes.length; x++)
			{
				for(int y = 0; y < notes[0].length; y++)
				{
					notes[x][y] = new JToggleButton();
					notes[x][y].setBackground(Color.WHITE);
					notes[x][y].setBorder(new LineBorder(Color.BLACK));
					notes[x][y].addMouseListener(this);
					if(loadSongNotes[x][y] == 1)
					{
						notes[x][y].setSelected(true);
						notes[x][y].setIcon(black);
					}
					notePanel.add(notes[x][y]);
				}
			}
			frame.add(notePanel,BorderLayout.CENTER);
		}
		if(e.getSource() == reset)
		{
			rows = 30;
			cols = 30;
			frame.remove(notePanel);
			notes = new JToggleButton[rows][cols];

			notePanel = new JPanel();
			notePanel.setLayout(new GridLayout(rows,cols,3,3));

			for(int x = 0; x < notes.length; x++)
			{
				for(int y = 0; y < notes[0].length; y++)
				{
					notes[x][y] = new JToggleButton();
					notes[x][y].setBackground(Color.WHITE);
					notes[x][y].setBorder(new LineBorder(Color.BLACK));
					notes[x][y].addMouseListener(this);
					notePanel.add(notes[x][y]);
				}
			}
			frame.add(notePanel,BorderLayout.CENTER);
		}
		frame.revalidate();
	}

	public static void main(String[] args)
	{
		ToneMatrix app = new ToneMatrix();
	}

}