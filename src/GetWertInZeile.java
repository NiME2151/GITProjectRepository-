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
	
	public String getKundennachnameInTable(JTable table) {
		int zeile = table.getSelectedRow();
		String rueckgabewert = (String) table.getValueAt(zeile, 2);
		System.out.println("r�ckgabe:" + rueckgabewert);
		return rueckgabewert;
	}
	
	public String getIBANInTable(JTable table) {
		int zeile = table.getSelectedRow();
		System.out.println("testFehler");
		String rueckgabewert = (String) table.getValueAt(zeile, 3);
		System.out.println("r�ckgabe:" + rueckgabewert);
		return rueckgabewert;
	}
}
