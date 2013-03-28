package amu.licence.edt.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import amu.licence.edt.model.beans.Admin;
import amu.licence.edt.model.beans.CRoom;
import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.beans.Level;
import amu.licence.edt.model.beans.Promo;
import amu.licence.edt.model.beans.Teacher;
import amu.licence.edt.model.dao.DAOFactory;
import amu.licence.edt.model.dao.DAOFactoryManager;

public class Model {

    private Admin user;
    private Schedule schedule;

    private DAOFactory daoFactory;

    private List<ModelObserver> observers;

    public Model() {
        super();
        this.daoFactory = DAOFactoryManager.getDAOFactory();
        this.observers = new ArrayList<ModelObserver>();
    }

    public void fireUserChanged() {
        for (ModelObserver o : observers) {
            o.userChanged(user);
        }
    }

    public void fireScheduleChanged() {
        for (ModelObserver o : observers) {
            o.scheduleChanged(schedule);
        }
    }

    public Admin getUser() {
        return user;
    }

    public void setUser(Admin user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean addObserver(ModelObserver o) {
        return this.observers.add(o);
    }

    public boolean removeObserver(ModelObserver o) {
        return this.observers.remove(o);
    }

    public boolean tryToConnect(String login, String password) {
        Admin a = daoFactory.getDAOAdmin().findByLoginPassword(login, password);
        if (a == null)
            return false;

        user = a;
        fireUserChanged();
        return true;
    }

    public void disconnect() {
        user = null;
        fireUserChanged();
    }

    public TreeNode getScheduleRootNode() {
        DAOFactory f = DAOFactoryManager.getDAOFactory();
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Emplois du temps");

        DefaultMutableTreeNode students = new DefaultMutableTreeNode("Etudiants");
        rootNode.add(students);

        for (Level l : f.getDAOLevel().findAll()) {
            DefaultMutableTreeNode pNode = new DefaultMutableTreeNode(l);
            Promo p = l.getPromo();
            for (Group g : p.getGroup()) {
                DefaultMutableTreeNode gNode = new DefaultMutableTreeNode(g);
                pNode.add(gNode);
            }
            students.add(pNode);
        }

        DefaultMutableTreeNode teachers = new DefaultMutableTreeNode("Enseignants");
        rootNode.add(teachers);

        for (Teacher t : f.getDAOTeacher().findAll()) {
            DefaultMutableTreeNode tNode = new DefaultMutableTreeNode(t);
            teachers.add(tNode);
        }

        DefaultMutableTreeNode crooms = new DefaultMutableTreeNode("Salles");
        rootNode.add(crooms);

        for (CRoom croom : f.getDAOCRoom().findAll()) {
            DefaultMutableTreeNode croomNode = new DefaultMutableTreeNode(croom);
            crooms.add(croomNode);
        }

        return rootNode;
    }

}
