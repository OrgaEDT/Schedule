package amu.licence.edt.view.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import amu.licence.edt.model.beans.Teacher;
import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;
import amu.licence.edt.view.renderers.ClassBasedCbbListDDR;

public class TeacherManagmentForm extends ViewComponent {

    Frame owner;

    private JComboBox cbbTeachers;
    private JPanel pnlPnlsManage;

    private JPanel pnlUnavailability;
    private JPanel pnlNbAdminHours;

    private JPanel pnlUnavForm;
    private JTextField txtUnavStartDate;
    private JTextField txtUnavDuration;
    private JButton btnAddUnavailability;

    private JPanel pnlNbAdminHoursForm;
    private JSpinner spinnNbAdminHours;
    private JButton btnChangeNbAdminHours;

    public TeacherManagmentForm(Presenter presenter, Frame owner) {
        super(presenter);
        this.owner = owner;
    }

    @Override
    protected Component createComponent() {
        JDialog dialog = new JDialog(owner, true);
        dialog.setLayout(new BorderLayout());
        dialog.setTitle("Administration enseignants");
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                 component.setLocation(owner.getLocation());
            }
        });

        pnlPnlsManage = new JPanel(new BorderLayout());

        List<Teacher> teachers = presenter.teacherManagmentFormCreating();
        cbbTeachers = new JComboBox(teachers.toArray());
        cbbTeachers.setRenderer(new ClassBasedCbbListDDR(presenter.getClassBasedDDR()));

        /* Panel Unavailability */

        pnlUnavailability = new JPanel(new GridLayout(0, 1));
        pnlUnavailability.setBorder(new TitledBorder(null, "Indisponibilitees",
                                                     TitledBorder.LEADING, TitledBorder.TOP,
                                                     null, Color.RED));

        pnlUnavForm = new JPanel(new GridLayout(0, 2));

        txtUnavStartDate = new JTextField();

        txtUnavDuration = new JTextField();

        btnAddUnavailability = new JButton("Ajouter");
        btnAddUnavailability.addActionListener(null);

        pnlUnavForm.add(new JLabel("Date de début"));
        pnlUnavForm.add(txtUnavStartDate);
        pnlUnavForm.add(new JLabel("Durée"));
        pnlUnavForm.add(txtUnavDuration);

        pnlUnavailability.add(pnlUnavForm);
        pnlUnavailability.add(btnAddUnavailability);

        /* Panel Nb Admin Hours */

        pnlNbAdminHours = new JPanel(new GridLayout(0, 1));
        pnlNbAdminHours.setBorder(new TitledBorder(null, "Heures d'administration",
                                                   TitledBorder.LEADING, TitledBorder.TOP,
                                                   null, Color.RED));

        pnlNbAdminHoursForm = new JPanel(new GridLayout(0, 2));

        spinnNbAdminHours = new JSpinner();
        spinnNbAdminHours.setModel(new SpinnerNumberModel(((Teacher)cbbTeachers.getSelectedItem()).getAdminHours(), 0, 18, 1));

        btnChangeNbAdminHours = new JButton("Modifier");
        btnChangeNbAdminHours.addActionListener(null);

        pnlNbAdminHoursForm.add(new JLabel("Heures effectués"));
        pnlNbAdminHoursForm.add(spinnNbAdminHours);

        pnlNbAdminHours.add(pnlNbAdminHoursForm);
        pnlNbAdminHours.add(btnChangeNbAdminHours);

        /* Constructing panel of manager panels */

        pnlPnlsManage.add(pnlUnavailability, BorderLayout.WEST);
        pnlPnlsManage.add(pnlNbAdminHours, BorderLayout.EAST);

        dialog.add(cbbTeachers, BorderLayout.NORTH);
        dialog.add(pnlPnlsManage, BorderLayout.SOUTH);

        dialog.pack();
        return dialog;
    }

}
