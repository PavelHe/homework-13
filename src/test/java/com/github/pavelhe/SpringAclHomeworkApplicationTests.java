package com.github.pavelhe;

import java.math.*;
import java.util.*;

import javax.transaction.*;

import com.github.pavelhe.model.*;
import com.github.pavelhe.repository.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.*;
import org.springframework.security.test.context.support.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SpringAclHomeworkApplicationTests {

	private static Long JAMES_ID = 1L;
	private static Long JOSH_ID = 2L;

	private static String JAMES_DESC = "James desc";
	private static String ADAM_DESC = "Adam desc";

	@Autowired
	private UserRepository userRepository;

	@Test
	@WithMockUser(username = "James")
	public void testJamesRead() {
		List<User> users = userRepository.findAll();
		assertEquals(1L, users.size());
		assertEquals(JAMES_DESC, users.get(0).getDescription());
	}

	@Test
	@WithMockUser(username = "James")
	public void testJamesEdit() {
		User user = userRepository.getOne(JAMES_ID);
		assertEquals(JAMES_DESC, user.getDescription());
		user.setAmount(BigDecimal.valueOf(900L));
		userRepository.save(user);
	}

	@Test(expected = AccessDeniedException.class)
	@WithMockUser(username = "Adam")
	public void testAdamEdit() {
		User user = userRepository.getOne(JOSH_ID);
		assertEquals(ADAM_DESC, user.getDescription());
		user.setAmount(BigDecimal.valueOf(900L));
		userRepository.save(user);
	}

	@Test(expected = AccessDeniedException.class)
	@WithMockUser(username = "Adam")
	public void testAdamDelete() {
		User user = userRepository.getOne(JOSH_ID);
		assertEquals(ADAM_DESC, user.getDescription());
		userRepository.delete(user);
	}

}
