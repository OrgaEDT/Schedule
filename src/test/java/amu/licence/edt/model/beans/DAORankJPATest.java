package amu.licence.edt.model.beans;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import amu.licence.edt.model.beans.Rank;
import amu.licence.edt.model.dao.DAORank;
import amu.licence.edt.model.dao.jpa.DAORankJPA;


public class DAORankJPATest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static DatabaseConnection dbUnitConnection;
    private static FlatXmlDataSet dataset;

    private DAORank dao = new DAORankJPA(entityManager);

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("schedulePU");
        entityManager = entityManagerFactory.createEntityManager();

        Connection connection = ((EntityManagerImpl) (entityManager.getDelegate())).getServerSession().getAccessor().getConnection();
        dbUnitConnection = new DatabaseConnection(connection);

        dataset = new FlatXmlDataSetBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("scheduleDataset.xml"));
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Before
    public void setUp() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataset);
    }

    @Test
    public void testFindAll() {
        List<Rank> ranks = dao.findAll();
        assertEquals("Enseignant", ranks.get(0).getLibel());
    }

}
