import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;

public class TableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
		{
		@Override
		public void run()
		{
		new TableExample();
		}
		});

	}
	
	public TableExample()
	{
	JFrame guiFrame = new JFrame();
	//make sure the program exits when the frame closes
	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	guiFrame.setTitle("Creating a Table Example");
	guiFrame.setSize(700,200);
	//This will center the JFrame in the middle of the screen
	guiFrame.setLocationRelativeTo(null);
	//Create the JTable using the ExampleTableModel implementing
	//the AbstractTableModel abstract class
	JTable table = new JTable(new ExampleTableModel());
	//Set the column sorting functionality on
	table.setAutoCreateRowSorter(true);
	//Uncomment the next line if you want to turn the grid lines off
	// table.setShowGrid(false);
	//Change the colour of the table - yellow for gridlines
	//blue for background
	table.setGridColor(Color.YELLOW);
	table.setBackground(Color.CYAN);
	
	TableColumn idColumn = table.getColumnModel().getColumn(0);
	idColumn.setPreferredWidth(10);
	//set the Event column to be larger than the rest and the Place column
	//to be smaller
	TableColumn nameColumn = table.getColumnModel().getColumn(1);
	nameColumn.setPreferredWidth(50);
	TableColumn phoneColumn = table.getColumnModel().getColumn(2);
	phoneColumn.setPreferredWidth(5);
	TableColumn addressColumn = table.getColumnModel().getColumn(3);
	addressColumn.setPreferredWidth(5);
	
	//Place the JTable object in a JScrollPane for a scrolling table
	JScrollPane tableScrollPane = new JScrollPane(table);
	guiFrame.add(tableScrollPane);
	guiFrame.setVisible(true);
	}
	//implement a table model by extending a class to use
	//the AbstractTableModel
	class ExampleTableModel extends AbstractTableModel{
	//Two arrays used for the table data
	String[] columnNames = {"ID", "Name", "Phone"
	, "Address"};
	Object[][] data = {
	{401870, "John", "9962983432", "Disney Land,2nd Street USA ", false },
	{401871, "Joe", "9962384432", " 9th Phase, Kukatpalli, Hyderabad, INDIA  ", false },
	{401872, "Nitin", "9962983632", "Chamber Lane, Chozan Apartments, Chennai,INDIA ", false },
	{401873, "Tai Nikhoma", "8862983432", "Near Xioami Colony, JAPAN ", false },
	
	
	};
	@Override
	public int getRowCount()
	{
	return data.length;
	}
	@Override
	public int getColumnCount()
	{
	return columnNames.length;
	}
	@Override
	public Object getValueAt(int row, int column)
	{
	return data[row][column];
	}
	//Used by the JTable object to set the column names
	@Override
	public String getColumnName(int column) {
	return columnNames[column];
	}
	//Used by the JTable object to render different
	//functionality based on the data type
	@Override
	public Class getColumnClass(int c) {
	return getValueAt(0, c).getClass();
	}
	@Override
	public boolean isCellEditable(int row, int column)
	{
	if (column == 0 || column == 1)
	{
	return false;
	}
	else
	{
	return true;
	}
	}
	}

}
