package com.keduit.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.BoardVO;
import com.keduit.persistence.DataSourcTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("test register에서 등록한 글");
		board.setContent("test register에서 등록한 글 내용");
		board.setWriter("test register에서 등록한 글 작성자");
		
		long bno= service.register(board);
		log.info("생성된 게시물 번호=======> "+ bno);
	}
	@Test
	public void testGetList() {
		service.getList().forEach(board->log.info(board));
		
	}
	@Test
	public void testGet() {
		log.info(service.get(13L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(13L);
		if(board == null) {
			return;
		}
		board.setTitle("modify한 제목");
		board.setContent("modify한 내용");
		board.setWriter("modify한 작성자");
		log.info("-------Modify result ==> "+service.modify(board));
		
	}
	
	@Test
	public void testDelete() {
		log.info("Remove result : "+service.remove(12L));
	}
}
