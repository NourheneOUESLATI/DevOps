package tn.esprit.spring.entities;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartementTest {

    Departement departement = new Departement();
    Employe employee = new Employe();
    Mission mission = new Mission();
    Entreprise enterprise = new Entreprise();
    @Test
    void setIdTest() {
        departement.setId(1);
        assertEquals(1,departement.getId());
    }



    @Test
    void setNameTest() {
        departement.setName("test");
        assertNotNull(departement.getName());
        assertEquals("test",departement.getName());
    }


    @Test
    void setEmployesTest() {
        departement.setEmployes(List.of(employee));
        assertNotNull(departement.getEmployes());
        assertArrayEquals(new Employe[]{employee},departement.getEmployes().toArray());
    }

    @Test
    void setMissionsTest() {
        departement.setMissions(List.of(mission));
        assertNotNull(departement.getMissions());
        assertArrayEquals(new Mission[]{mission},departement.getMissions().toArray());
    }

    @Test
    void setEntrepriseTest() {
        departement.setEntreprise(enterprise);
        assertNotNull(departement.getEntreprise());
        assertEquals(enterprise,departement.getEntreprise());
    }
}
