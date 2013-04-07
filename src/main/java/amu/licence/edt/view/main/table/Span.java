package amu.licence.edt.view.main.table;

public class Span {

    private final int row;
    private final int column;
    private final int width;

    public Span(int row, int column, int width) {
        this.row = row;
        this.column = column;
        this.width = width;
    }

    public boolean intersect(Span other) {
        return isDefined(other.row, other.column) ||
               isDefined(other.row, other.column + other.width - 1) ||
               other.isDefined(row, column) ||
               other.isDefined(row, column + width - 1);
    }

    /**
     * Checks if the row and column fall within the boundaries of the span.
     */
    public boolean isDefined(int row, int column) {
        return row == this.row &&
               column >= this.column && column < (this.column + this.width);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        result = prime * result + width;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Span other = (Span) obj;
        if (column != other.column)
            return false;
        if (row != other.row)
            return false;
        if (width != other.width)
            return false;
        return true;
    }

}
