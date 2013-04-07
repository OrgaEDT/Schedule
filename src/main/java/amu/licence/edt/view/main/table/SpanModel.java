package amu.licence.edt.view.main.table;

import java.util.HashSet;
import java.util.Set;

public class SpanModel {

    private Set<Span> spans = new HashSet<Span>();

    void addSpan(Span span) {
        if (span == null) {
            throw new NullPointerException("span is null");
        }
        for (Span s : spans) {
            if (s.intersect(span)) {
                throw new IllegalArgumentException("cannot insert a span that intersects with another span in the map");
            }
        }
        spans.add(span);
    }

    void removeSpan(Span span) {
        spans.remove(span);
    }

    void clear() {
        spans.clear();
    }

    /**
     * Get the span that is defined at this row and column.
     */
    public Span getDefinedSpan(int row, int column) {
        for (Span s : spans) {
            if (s.isDefined(row, column)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Get the span size of the cell at (row, column)
     */
    public int spanSize(int row, int column) {
        Span s = getDefinedSpan(row, column);
        return (s != null) ? s.getWidth() : 1;
    }

    /**
     * Get the index of a span covering a cell
     */
    public int spanIndex(int row, int column) {
        Span s = getDefinedSpan(row, column);
        return (s != null) ? s.getColumn() : column;
    }

}
