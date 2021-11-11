package tn.esprit.spring.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@ExtendWith(MockitoExtension.class)
class TimesheetServiceImplTest {
	@Mock
	private TimesheetRepository TimeRep;
	@Mock
	private MissionRepository Mrep;
	private TimesheetServiceImpl TimeService;
	private TimesheetServiceImpl TimeService1;
	 
	@BeforeEach
	void setUp() throws Exception {
		TimeService=new TimesheetServiceImpl(Mrep);
		TimeService1=new TimesheetServiceImpl(TimeRep);
	}

	@Test
	void testAjouterMission() {
		Mission M=new Mission("dev","ops");
		TimeService.ajouterMission(M);
		ArgumentCaptor<Mission> tArgumentCaptor= ArgumentCaptor.forClass(Mission.class);
		verify(Mrep).save(tArgumentCaptor.capture());
		
		Mission capturedM=tArgumentCaptor.getValue();
	 
		assertThat( capturedM).isEqualTo(M);
	}
	
	@Test 
	void testfindAllBytimesheetPK()  {
		Date date = java.util.Date.from( Instant.now() ) ;
		TimesheetPK TSpk=new TimesheetPK(1,1,date,date);
		Timesheet TS=new Timesheet(TSpk);
		List<Timesheet> data= Arrays.asList(TS);
		when(TimeRep.findAll()).thenReturn(data);
 		
 		//test
 		 
 	//	l.info("test..");	 
 		assertThat(TimeService1.findAllTimesheet()).isEqualTo(data);
		 
	}	@Test
	void testAjouterTimesheet() {
		
	}
	

}
