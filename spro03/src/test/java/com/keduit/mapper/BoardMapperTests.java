package com.keduit.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	@Test
	public void testGetTime2() {
		log.info("----getTime----");
		log.info(mapper.getTime());
	}
	
	@Test
	public void testInsert() {
		BoardVO bVO = new BoardVO();
		bVO.setTitle("test작성글");
		bVO.setContent("test내용");
		bVO.setWriter("test작성자");
		
		mapper.insert(bVO);
		log.info("----"+bVO);
	}
}
