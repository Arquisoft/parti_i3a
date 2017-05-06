package es.uniovi.asw.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import es.uniovi.asw.domain.Proposal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class ProposalRepositoryTest {

	@Autowired
	private ProposalRepository pR;

	@Test
	public void test() {
		Proposal p;

		p = pR.findById(4L);

		assertTrue(p.getTitle().equals("Politicians to jail"));

	}

}
