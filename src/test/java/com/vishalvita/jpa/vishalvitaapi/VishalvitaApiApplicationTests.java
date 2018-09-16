package com.vishalvita.jpa.vishalvitaapi;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VishalvitaApiApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(new Date());
	}

}
