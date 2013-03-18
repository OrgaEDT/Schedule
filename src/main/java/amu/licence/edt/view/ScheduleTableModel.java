package amu.licence.edt.view;

import java.awt.Color;

import javax.swing.table.AbstractTableModel;

import amu.licence.edt.model.beans.UE;


public class ScheduleTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private final UE[][] donnees;
	private final String[] entete = { "matin", "midi", "soir" };

	public ScheduleTableModel() {
		super();
		donnees = new UE[][] {
				{ new UE ("ue1", Color.decode("797798")), new UE("ue2", Color.RED),  new UE ("ue3", Color.BLUE) },
				{ new UE ("ue4", Color.YELLOW),  new UE("ue5", Color.GRAY), new UE ("ue6", Color.GREEN) },
		};
	}

	@Override
	public Class<UE> getColumnClass(int columnIndex) {
		return UE.class;
	}

	public int getColumnCount() {
		return entete.length;
	}

	public int getRowCount() {
		return donnees.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}

	public Object getValueAt(int arg0, int arg1) {
		return donnees[arg0][arg1];
	}

}
