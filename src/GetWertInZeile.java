import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//
public class GetWertInZeile {
	
	public String getWertInZeile(JTable table) {
		int zeile = table.getSelectedRow();
		String rueckgabewert = (String) table.getValueAt(zeile, 0);
		System.out.println(rueckgabewert);
		return rueckgabewert;
	}
	
	public String getKundennachnameInTable(JTable table) {
		int zeile = table.getSelectedRow();
		String rueckgabewert = (String) table.getValueAt(zeile, 2);
		System.out.println("rückgabe:" + rueckgabewert);
		return rueckgabewert;
	}
	
	public String getZurueckgebenFenster(JTable table) {
		int zeile = table.getSelectedRow();
		String rueckgabewert = (String) table.getValueAt(zeile, 3);
		System.out.println(rueckgabewert);
		return rueckgabewert;
	}
	
	public String getAusleihCounterInTable(JTable table) {
		int zeile = table.getSelectedRow();
		String rueckgabewert = (String) table.getValueAt(zeile, 12);
		System.out.println(rueckgabewert);
		return rueckgabewert;
	}
	
	public String getWertInZeileVariabel(JTable table, int zeileInTable) {
		int zeile = table.getSelectedRow();
		String rueckgabewert = (String) table.getValueAt(zeile, zeileInTable);
		System.out.println(rueckgabewert);
		return rueckgabewert;
	}
}
