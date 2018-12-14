<<<<<<< HEAD
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class KundeInTabelleAuswaehlen {

	public KundeInTabelleAuswaehlen(JTable kundenlisteTable) {
		// TODO Auto-generated constructor stub
	}

	public void kundeInTabelleAuswaehlen(JTable kundenlisteTable) {
		kundenlisteTable.setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = kundenlisteTable.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String ausgewaehlterKunde = null;

				int[] zeile = kundenlisteTable.getSelectedRows();
				int[] spalte = kundenlisteTable.getSelectedColumns();

				for (int i = 0; i < zeile.length; i++) {
					for (int j = 0; j < spalte.length; j++) {
						ausgewaehlterKunde = (String) kundenlisteTable.getValueAt(zeile[i], spalte[j]);
						System.out.println(ausgewaehlterKunde);
					}
				}
				System.out.println(ausgewaehlterKunde);
			}
		});
	}

}
=======
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class KundeInTabelleAuswaehlen {

	public KundeInTabelleAuswaehlen(JTable kundenlisteTable) {
		// TODO Auto-generated constructor stub
	}

	public void kundeInTabelleAuswaehlen(JTable kundenlisteTable) {
		kundenlisteTable.setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = kundenlisteTable.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String ausgewaehlterKunde = null;

				int[] zeile = kundenlisteTable.getSelectedRows();
				int[] spalte = kundenlisteTable.getSelectedColumns();

				for (int i = 0; i < zeile.length; i++) {
					for (int j = 0; j < spalte.length; j++) {
						ausgewaehlterKunde = (String) kundenlisteTable.getValueAt(zeile[i], spalte[j]);
						System.out.println(ausgewaehlterKunde);
					}
				}
				System.out.println(ausgewaehlterKunde);
			}
		});
	}

}
>>>>>>> 210b9c96296de825c737a89edf86a3c4b0a4d511
