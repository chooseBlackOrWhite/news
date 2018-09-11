package service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import bean.Comment;
import bean.CommentUserView;
import tools.PageInformation;

public class CommentServiceTest {

	@Test
	public void testGetOnePage() throws Exception {
		CommentService commentService=new CommentService();
		PageInformation pageInformation=new PageInformation();
		List<CommentUserView> commentUserViews=commentService.getOnePage(pageInformation);
		assertNotNull(commentUserViews);
	}

	@Test
	public void testPaise() throws SQLException, Exception {
		CommentService commentService=new CommentService();
		Integer commentId=30;
		Integer interger=commentService.paise(commentId);
		assertTrue(interger>=0);
	}
	
	@Test
	public void testAddComment() {
		CommentService commentService=new CommentService();
		Comment comment=new Comment();
		Integer interger=commentService.addComment(comment);
		assertTrue(interger>=0);
	}
	
	@Test
	public void testAddCommentToComment() {
		CommentService commentService=new CommentService();
		Comment comment=new Comment();
		Integer interger=commentService.addCommentToComment(comment);
		assertTrue(interger>=0);
	}
	
	
}
