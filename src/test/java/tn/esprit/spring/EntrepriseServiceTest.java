package tn.esprit.spring;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
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

    /**
     * TEST METHODS RELATED TO DEPARTMENT CLASS
     */

    /**
     * TEST METHOD AJOUT DEPARTEMENT
     */
    @Test
    void testAjouterDepartement() {
        Departement d = new Departement();
        d.setName("Département de test");
        d.setEntreprise(entrepriseService.getEntrepriseById(1));
        departmentRepository.save(d);
        Optional<Departement> d2 = departmentRepository.findById(d.getId());
        assertEquals(d.getName(), d2.get().getName());
    }

    /**
     * TEST METHOD AFFECTATION DEPARTEMENT
     */
    @Test
    void testAffecterDepartementAEntreprise() {
        Optional<Departement> d = departmentRepository.findById(1);
        Entreprise e = entrepriseService.getEntrepriseById(1);
        assertAll("properties",
                () -> {
                    assertNotNull(d);
                    assertNotNull(e);
                },
                () -> {
                    entrepriseService.affecterDepartementAEntreprise(1,1);
                    assertEquals(d.get().getEntreprise().getId(), e.getId());
                }
        );
    }

    /**
     * TEST METHODS GET ALL DEPARTEMENTS NAMES BY ENTREPRISE ID
     */
    @Test
    void testGetAllDepartementsNamesByEntreprise() {
        Entreprise e = entrepriseService.getEntrepriseById(1);
        List<String> d = entrepriseService.getAllDepartementsNamesByEntreprise(1);
        assertAll("properties",
                () -> assertNotNull(d),
                () -> assertEquals(d.size(), e.getDepartements().size()),
                () -> assertArrayEquals(d.toArray(), e.getDepartements().toArray()));
    }

    /**
     * TEST METHOD DELETE DEPARTEMENT
     */
    @Test
    void testDeleteDepartementById() {
        assertNotNull(departmentRepository.findById(1));
        entrepriseService.deleteDepartementById(1);
        assertNull(departmentRepository.findById(1));
    }

}