package amu.licence.edt.view.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import amu.licence.edt.model.beans.CRoom;
import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.beans.SessionType;
import amu.licence.edt.model.beans.TU;
import amu.licence.edt.model.beans.Teacher;
import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;
import amu.licence.edt.view.renderers.ListCellStrRenderer;

public class CRoomTeacherChooser extends ViewComponent {

    private JFrame owner;
    private JDialog thisDialog;

    private TU tu;
    private SessionType st;
    private Group group;
    private Date date;
    private Integer duration;

    private JLabel lblChoose;

    private JPanel pnlLists;
    private JList jlistCRooms;
    private JList jlistTeachers;

    private JButton btnValidate;

    public CRoomTeacherChooser(Presenter presenter, JFrame owner) {
        super(presenter);
        this.owner = owner;
    }

    @Override
    protected Component createComponent() {
        JDialog dialog = new JDialog(owner, true);
        dialog.setLayout(new BorderLayout());
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                 component.setLocation(owner.getLocation());
            }
        });

        lblChoose = new JLabel("Choisir une salle et un enseignant");

        pnlLists = new JPanel(new BorderLayout());

        jlistCRooms = new JList(new DefaultListModel());
        jlistCRooms.setCellRenderer(new ListCellStrRenderer(presenter.getClassBasedDDR()));
        jlistCRooms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jlistTeachers = new JList(new DefaultListModel());
        jlistTeachers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlistTeachers.setCellRenderer(new ListCellStrRenderer(presenter.getClassBasedDDR()));

        pnlLists.add(new JScrollPane(jlistCRooms), BorderLayout.WEST);
        pnlLists.add(new JScrollPane(jlistTeachers), BorderLayout.EAST);

        btnValidate = new JButton("Valider");
        btnValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnValidateActionPerformed(e);
            }
        });

        dialog.add(lblChoose, BorderLayout.NORTH);
        dialog.add(pnlLists, BorderLayout.CENTER);
        dialog.add(btnValidate, BorderLayout.SOUTH);

        thisDialog = dialog;
        return thisDialog;
    }

    public JDialog fill(List<CRoom> crooms, List<Teacher> teachers, TU tu, SessionType st, Group group, Date date, Integer duration) {
        this.tu = tu;
        this.st = st;
        this.group = group;
        this.date = date;
        this.duration = duration;
        DefaultListModel lmCR = (DefaultListModel)jlistCRooms.getModel();
        DefaultListModel lmT = (DefaultListModel)jlistTeachers.getModel();
        lmCR.removeAllElements();
        lmT.removeAllElements();
        for (CRoom cr : crooms) {
            lmCR.addElement(cr);
        }
        for (Teacher t : teachers) {
            lmT.addElement(t);
        }
        thisDialog.pack();
        return thisDialog;
    }

    protected void btnValidateActionPerformed(ActionEvent e) {
        presenter.validateAddSessionButtonPressed(date, duration, tu,
                                                  (Teacher)jlistTeachers.getSelectedValue(),
                                                  (CRoom)jlistCRooms.getSelectedValue(),
                                                  st, group);
    }

}
