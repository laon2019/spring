package com.keduit.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.BoardVO;
import com.keduit.domain.Criteria;

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
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(5);
		cri.setAmount(10);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
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
		log.info("-------------------------"+bVO);
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key test");
		board.setContent("새로 작성하는 글 내용 select key test");
		board.setWriter("user99");
		
		mapper.insertSelectKey(board);
		
		log.info("-------------------------"+board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = new BoardVO();
		board = mapper.read(5L);
		log.info("------------"+board);
	}
	
	@Test
	public void testDelete() {
		int result = mapper.delete(3L);
		log.info("-------------------------");
		log.info("delete개수"+result);
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setTitle("업데이트 작성글");
		board.setContent("업데이트 내용");
		board.setWriter("업데이트 작성자");
		board.setBno(5L);
		
		int result = mapper.update(board);
		log.info("---------------");
		log.info("update 갯수 =>" + result);
		
	}
}
