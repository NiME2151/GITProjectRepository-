import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GetWertInZeile {
	
	public String getWertInZeile(JTable table) {
		int zeile = table.getSelectedRow();
		String rueckgabewert = (String) table.getValueAt(zeile, 0);
		System.out.println(rueckgabewert);
		return rueckgabewert;
	}
	
	public String getWertInZeileAusleihfenster(JTable table) {
		int zeile = table.getSelectedRow();
		String rueckgabewert = (String) table.getValueAt(zeile, 1);
		System.out.println(rueckgabewert);
		return rueckgabewert;
	}
}