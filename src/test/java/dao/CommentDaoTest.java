package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import bean.Comment;
import bean.CommentUserView;
import dao.CommentDao;
import dao.DatabaseDao;
import tools.PageInformation;

public class CommentDaoTest {

	@Test
	public void testGetOnePage() throws Exception {
		CommentDao commentDao=new CommentDao();
		PageInformation pageInformation =new PageInformation();
		DatabaseDao databaseDao=new DatabaseDao();
		List<CommentUserView> commentUserViews = commentDao.getOnePage(pageInformation, databaseDao);
		assertNotNull(commentUserViews);
	}

	@Test
	public void testPaise() throws Exception{
		CommentDao commentDao=new CommentDao();
		PageInformation pageInformation =new PageInformation();
		DatabaseDao databaseDao=new DatabaseDao();
		List<CommentUserView> commentUserViews=commentDao.getOnePage(pageInformation, databaseDao);
		Integer commentId=commentUserViews.get(0).getCommentId();
		Integer interger=commentDao.paise(commentId);
		assertTrue(interger>0);
	}
	
	@Test
	public void testGetStairByNewsId() throws Exception{
		CommentDao commentDao=new CommentDao();
		Integer newsId=0;
		DatabaseDao databaseDao=new DatabaseDao();
		Integer interger=commentDao.getStairByNewsId(newsId, databaseDao);
		assertTrue(interger>0);
	}
	
	@Test
	public void testAddComment() throws Exception{
		CommentDao commentDao=new CommentDao();
		Comment comment=new Comment();
		DatabaseDao databaseDao=new DatabaseDao();
		Integer interger=commentDao.addComment(comment, databaseDao);
		assertTrue(interger>0);
	}
	
	@Test
	public void testGetById() throws Exception{
		CommentDao commentDao=new CommentDao();
		
		PageInformation pageInformation =new PageInformation();
		DatabaseDao databaseDao=new DatabaseDao();
		List<CommentUserView> commentUserViews=commentDao.getOnePage(pageInformation, databaseDao);
		Integer commentId=commentUserViews.get(0).getCommentId();
		
		Comment comment=commentDao.getById(commentId, databaseDao);
		assertNull(comment);
	}
	
	@Test
	public void testGetByIdFromView() throws Exception{
		CommentDao commentDao=new CommentDao();
		PageInformation pageInformation =new PageInformation();
		DatabaseDao databaseDao=new DatabaseDao();
		List<CommentUserView> commentUserViews=commentDao.getOnePage(pageInformation, databaseDao);
		Integer commentId=commentUserViews.get(0).getCommentId();
		
		CommentUserView commentUserView=commentDao.getByIdFromView(commentId, databaseDao);
		assertNull(commentUserView);
	}
}
