package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.Tenis;

public class TenisTableModel extends AbstractTableModel {
	
	private List<Tenis> tenis;

    private final String[] columns = {
        "Nombre", "Marca", "Precio", "Talla", "Color", "Stock"
    };

    public TenisTableModel(List<Tenis> tenis) {
        this.tenis = tenis;
    }

    @Override
    public int getRowCount() {
        return tenis.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tenis teni = tenis.get(rowIndex);

        switch (columnIndex) {
        case 0: 
        	return teni.getNombre();
        case 1: 
            return teni.getMarca();
        case 2: 
            return "$" + teni.getPrecio();
        case 3: 
            return teni.getTalla();
        case 4: 
            return teni.getColor();
        case 5: 
            return teni.getStock();
        case 6: 
            return teni.getTipo();
        }
        
        return null;
    }

    public Tenis getTenisAt(int row) {
        return tenis.get(row);
    }

    public void setTenis(List<Tenis> tenis) {
        this.tenis = tenis;
        fireTableDataChanged();
    }

    public void addRow(Tenis teni) {
        int row = tenis.size();
        tenis.add(teni);
        fireTableRowsInserted(row, row);
    }

    public void removeRow(int row) {
        tenis.remove(row);
        fireTableRowsDeleted(row, row);
    }
	
	

}
