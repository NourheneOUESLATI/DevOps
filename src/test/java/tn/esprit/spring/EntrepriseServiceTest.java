package tn.esprit.spring;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEntrepriseService;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EntrepriseServiceTest {

    @Autowired
    DepartementRepository departmentRepository;
    @Autowired
    IEntrepriseService entrepriseService;

    private static final Logger LOGGER = Logger.getLogger(EntrepriseServiceTest.class);

    @Test
    void ajouterEntrepriseTest() {
        Entreprise e = new Entreprise();
        e.setName("SAP");
        int id = entrepriseService.ajouterEntreprise(e);
        assertAll("",
                () -> assertEquals(id, e.getId()),
                () -> assertEquals(e.getName(), "SAP")
        );
    }

    @Test
    void testAjouterDepartement() {
        Departement d = new Departement();
        d.setName("Département de test");

        int id = entrepriseService.ajouterDepartement(d);
        assertAll("",
                () -> assertEquals(id, d.getId()),
                () -> assertEquals(d.getName(), "Département de test")
        );
    }

    @Test
    void testAffecterDepartementAEntreprise() {
        Entreprise e = new Entreprise();
        Departement d = new Departement();
        d.setName("Département de test");
        d.setEntreprise(e);
        e.setDepartements(List.of(d));
        entrepriseService.ajouterEntreprise(e);
        entrepriseService.affecterDepartementAEntreprise(d.getId(), e.getId());
        assertEquals(e.getDepartements().get(0).getId(), d.getId());
    }

    /**
     * TEST METHODS GET ALL DEPARTEMENTS NAMES BY ENTREPRISE ID
     */

    @Test
    void testGetAllDepartementsNamesByEntreprise() {

        Entreprise e = new Entreprise();
        Departement d = new Departement();
        d.setName("Département de test");
        d.setEntreprise(e);
        e.setDepartements(List.of(d));
        entrepriseService.ajouterEntreprise(e);
        assertArrayEquals(entrepriseService.getAllDepartementsNamesByEntreprise(e.getId()).toArray(), new String[]{"Département de test"});

    }

    /**
     * TEST METHOD DELETE DEPARTEMENT
     */

    @Test
    void testDeleteDepartementById() {
        assertNotNull(departmentRepository.findById(1));
        entrepriseService.deleteDepartementById(1);
        assertEquals(Optional.empty(), departmentRepository.findById(1));
    }

}