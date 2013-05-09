package amu.licence.edt.view.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.beans.Level;
import amu.licence.edt.model.beans.SessionType;
import amu.licence.edt.model.beans.TU;
import amu.licence.edt.model.dao.DAOFactory;
import amu.licence.edt.model.dao.DAOFactoryManager;
import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;
import amu.licence.edt.view.renderers.ListCellStrRenderer;

public class LevelManagmentForm extends ViewComponent {

    private Frame owner;
    private JDialog thisDialog;

    private Level level;

    private JLabel lblInstructions;

    private JPanel pnlPnlsManage;

    private JPanel pnlUnplannedSessions;
    private ButtonGroup btnSessionsGroup;
    private Character TUSTSeparator; // TU / SessionType Separator

    private JPanel pnlPlanSessionForm;
    private JLabel lblGroup;
    private JLabel lblStartDay;
//    private JLabel lblHourStart;
    private JLabel lblDuration;
    private JComboBox groupInput;
    private JSpinner startDayInput;
//    private JSpinner hourStartInput;
    private JSpinner durationInput;

    private JButton btnValidate;

    public LevelManagmentForm(Presenter presenter, Frame owner, Level level) {
        super(presenter);
        this.owner = owner;
        this.level = level;
        fillDialogWithLevelData();
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

        lblInstructions = new JLabel("Choisir un cours à placer :");

        pnlPnlsManage = new JPanel(new BorderLayout());

        /* Panel unplanned sessions is filled in fillDialogWithLevelData() */
        pnlUnplannedSessions = new JPanel(new GridLayout(0, 1));

        /* Panel plan session form */

        pnlPlanSessionForm = new JPanel(new GridLayout(0, 2));

        lblGroup = new JLabel("Groupe");
        groupInput = new JComboBox();
        groupInput.setRenderer(new ListCellStrRenderer(presenter.getClassBasedDDR()));

        lblStartDay = new JLabel("Date de début");
        startDayInput = new JSpinner();
        startDayInput.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        startDayInput.setEditor(new JSpinner.DateEditor(startDayInput, "d MMMM yyyy - HH:00"));

//        lblHourStart = new JLabel("Heure de début");
//        hourStartInput = new JSpinner();
//        hourStartInput.setModel(new SpinnerNumberModel(8, 8, 19, 1));

        lblDuration = new JLabel("Durée");
        durationInput = new JSpinner();
        durationInput.setModel(new SpinnerNumberModel(2, 1, 4, 1));

        pnlPlanSessionForm.add(lblGroup);
        pnlPlanSessionForm.add(groupInput);
        pnlPlanSessionForm.add(lblStartDay);
        pnlPlanSessionForm.add(startDayInput);
//        pnlPlanSessionForm.add(lblHourStart);
//        pnlPlanSessionForm.add(hourStartInput);
        pnlPlanSessionForm.add(lblDuration);
        pnlPlanSessionForm.add(durationInput);

        pnlPnlsManage.add(new JScrollPane(pnlUnplannedSessions), BorderLayout.WEST);
        pnlPnlsManage.add(pnlPlanSessionForm, BorderLayout.EAST);

        btnValidate = new JButton("Recherche");
        btnValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnValidateActionPerformed(e);
            }
        });
        btnValidate.setEnabled(false);

        dialog.add(lblInstructions, BorderLayout.NORTH);
        dialog.add(pnlPnlsManage, BorderLayout.CENTER);
        dialog.add(btnValidate, BorderLayout.SOUTH);

        thisDialog = dialog;
        return thisDialog;
    }

    private void fillDialogWithLevelData() {
        pnlUnplannedSessions.removeAll();
        thisDialog.setTitle("Administration niveau " + level.getLibel());
        Iterable<Object[]> unplanned = presenter.levelManagmentFormCreating(level);
        btnSessionsGroup = new ButtonGroup();
        TUSTSeparator = '#';
        for (Object[] o : unplanned) {
            JPanel pnlUnplannedTU = new JPanel(new GridLayout(0, 1));
            pnlUnplannedTU.setBorder(new TitledBorder(null, (String)o[0],
                                     TitledBorder.LEADING, TitledBorder.TOP,
                                     null, Color.RED));
            for (int i = 1; i < o.length; i += 2) {
                if (((BigDecimal)o[i+1]).compareTo(BigDecimal.ZERO) > 0) {
                    JRadioButton radioBtn = new JRadioButton(o[i] + " : " + o[i+1]);
                    radioBtn.setActionCommand(o[0] + TUSTSeparator.toString() + o[i]);
                    radioBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            btnValidate.setEnabled(true);
                        }
                    });
                    btnSessionsGroup.add(radioBtn);
                    pnlUnplannedTU.add(radioBtn);
                }
            }
            if (pnlUnplannedTU.getComponentCount() > 0) {
                pnlUnplannedSessions.add(pnlUnplannedTU);
            }
        }
        groupInput.removeAllItems();
        groupInput.addItem(new Group());    // whole promo
        for (Group g : level.getPromo().getGroups()) {
            groupInput.addItem(g);
        }
        thisDialog.pack();
    }

    private void btnValidateActionPerformed(ActionEvent e) {
        if (btnSessionsGroup.getSelection() == null) return;
        String[] splitedAC = btnSessionsGroup.getSelection().getActionCommand().split(TUSTSeparator.toString());
        DAOFactory daoF = DAOFactoryManager.getDAOFactory();
        TU tu = daoF.getDAOTU().getByLibel(splitedAC[0]);
        SessionType st = daoF.getDAOSessionType().getByLibel(splitedAC[1]);
        Group group = (Group) groupInput.getSelectedItem();
        Date date = (Date) startDayInput.getValue();
        Integer duration = (Integer) durationInput.getValue();
        if (group.getId() == 0) group.setGroupSize(level.getPromo().getSize());
        presenter.btnSearchCRoomTeacherPressed(tu, st, group, date, duration);
    }

}
