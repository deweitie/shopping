package com.love.shopping.model;


import java.util.List;
import java.util.Map;

import com.love.shopping.dao.UserDao;
import com.love.shopping.daoimpl.UserDaoImpl;
import com.love.shopping.po.Note;
import com.love.shopping.po.Page;
import com.love.shopping.po.User;
import com.love.shopping.dao.AdminBookDao;
import com.love.shopping.dao.AdminInformDao;
import com.love.shopping.dao.AdminLoginDao;
import com.love.shopping.dao.AdminNoteDao;
import com.love.shopping.dao.AdminOrderDao;
import com.love.shopping.dao.AdminSubTypeDao;
import com.love.shopping.dao.AdminSuperTypeDao;
import com.love.shopping.dao.AdminUserDao;
import com.love.shopping.dao.BookDao;
import com.love.shopping.dao.OrderDao;
import com.love.shopping.dao.SubTypeDao;
import com.love.shopping.dao.SuperTypeDao;
import com.love.shopping.daoimpl.AdminBookDaoImpl;
import com.love.shopping.daoimpl.AdminInformDaoImpl;
import com.love.shopping.daoimpl.AdminLoginDaoImpl;
import com.love.shopping.daoimpl.AdminNoteDaoImpl;
import com.love.shopping.daoimpl.AdminOrderDaoImpl;
import com.love.shopping.daoimpl.AdminSubTypeDaoImpl;
import com.love.shopping.daoimpl.AdminSuperTypeDaoImpl;
import com.love.shopping.daoimpl.AdminUserDaoImpl;
import com.love.shopping.daoimpl.BookDaoImpl;
import com.love.shopping.daoimpl.OrderDaoImpl;
import com.love.shopping.daoimpl.SubTypeDaoImpl;
import com.love.shopping.daoimpl.SuperTypeDaoImpl;
import com.love.shopping.po.Admin;
import com.love.shopping.po.Book;
import com.love.shopping.po.BookPager;
import com.love.shopping.po.Inform;
import com.love.shopping.po.InformPager;
import com.love.shopping.po.NotePager;
import com.love.shopping.po.Order;
import com.love.shopping.po.OrderFreezePager;
import com.love.shopping.po.OrderItem;
import com.love.shopping.po.OrderNotSendPager;
import com.love.shopping.po.OrderPager;
import com.love.shopping.po.OrderSendPager;
import com.love.shopping.po.SubType;
import com.love.shopping.po.SuperType;
import com.love.shopping.po.UserPager;

public class Model {
	private UserDao ud = new UserDaoImpl();
	private BookDao bd = new BookDaoImpl();
	private OrderDao od = new OrderDaoImpl();
	private SuperTypeDao superDao = new SuperTypeDaoImpl();

	private SubTypeDao subDao = new SubTypeDaoImpl();

	public List<SuperType> showAllSuperType() {
		return superDao.showAllSuperType();
	}

	public List<SubType> showAllSubTypeBySuperId(int superId) {
		return subDao.showAllSubTypeBySuperId(superId);
	}
	//用户注册
	public boolean addUser(User user) {
		return ud.addUser(user);
	}
	//用户登录
	public User userLogin(String name,String password) {
		return ud.userLogin(name,password);
	}
	//检查用户名是否存在
	public boolean checkNameExist(String name){
		return ud.checkNameExist(name);
	}
	//用户管理页面
	public List listUser() {
		return ud.listUser();
	}
	//分页显示用户
//	public Page doPage(int currentPage,int pageSize){
//		return ud.doPage(currentPage, pageSize);
//	}
	//根据ID删除用户
	public boolean delete(int id,String powerType){
		return ud.delete(id,powerType);
	}
	//根据ID更改用户权限
	public boolean changePower(int id,String powerType){
		return ud.changePower(id,powerType);
	}
	//	 根据用户名，获取其权限
	public String getPower(String name){
		return ud.getPower(name);
	}
	//根据用户名，找到该用户
	public User getUser(String name){
		return ud.getUser(name);
	}
	//显示书籍
	public List<Book> showBooks(int type,int flag) {
		return bd.showBooks(type, flag);
	}
	//根据书籍的bookId来显示书籍的详细信息
	public Book showBookById(int bookId){
		return bd.showBookById(bookId);
	}
	//添加订单，并返回订一个单号
	public int addOrder(Order order){
		return od.addOrder(order);
	}
	//分页显示书籍
	public Page doPage(int type,int currentPage,int pageSize){
		return bd.doPage(type,currentPage, pageSize);
	}
	//根据用输入的关键字搜索相关书籍
	public List<Book> searchBooks(String keywords){
		return bd.searchBooks(keywords);
	}
	/**
	 * 分页显示书籍
	 * @param currentPage 显示出来的当前页码
	 * @param pageSize 每页显示数目
	 * @return Page
	 */
	public Page doPage(String keywords,int currentPage,int pageSize){
		return bd.doPage(keywords, currentPage, pageSize);
	}
	//显示所有用户留言
	public List<Note> showNote(){
		return ud.showNote();
	}
	/**
	 * 分页显示所有用户留言
	 * @param currentPage 显示出来的当前页码
	 * @param pageSize 每页显示数目
	 * @return Page
	 */
	public Page doNotePage(int currentPage,int pageSize){
		return ud.doNotePage(currentPage, pageSize);
	}
	//用户添加留言
	public boolean addNote(Note note){
		return ud.addNote(note);
	}
	/**
	 * 根据用户选择的搜索条件搜索相关书籍
	 * @param superTypeId 所属大类的ID
	 * @param subTypeId 所属小类的ID
	 * @param searchMethod （可以是按作者、书名、出版社、ISBN、价格中的一个）
	 * @param upLoadTime 书籍上价时间
	 * @return List
	 */
	public List<?> searchBooksByConditions(int superTypeId,int subTypeId,String searchMethod,String upLoadTime){
		return bd.searchBooksByConditions(superTypeId, subTypeId, searchMethod, upLoadTime);
	}
	/**
	 * 根据用户选择的搜索条件搜索相关书籍
	 * @param superTypeId 所属大类的ID
	 * @param subTypeId 所属小类的ID
	 * @param searchMethod （可以是按作者、书名、出版社、ISBN、价格中的一个）
	 * @param upLoadTime 书籍上价时间
	 */
	public Page doPageByConditons(int superTypeId,int subTypeId,String searchMethod,String upLoadTime,int currentPage,int pageSize){
		return bd.doPageByConditons(superTypeId, subTypeId, searchMethod, upLoadTime, currentPage, pageSize);
	}
	
	
	
	/**
	 * 
	 * 后台部分
	 */


	private AdminUserDao userDao = new AdminUserDaoImpl();
	private AdminSubTypeDao subTypeDao = new AdminSubTypeDaoImpl();
	private AdminSuperTypeDao superTypeDao = new AdminSuperTypeDaoImpl();
	private AdminBookDao bookDao = new AdminBookDaoImpl();
	private AdminNoteDao noteDao = new AdminNoteDaoImpl();
	private AdminLoginDao adminLoginDao = new AdminLoginDaoImpl();
	private AdminInformDao adminInformDao = new AdminInformDaoImpl();
	private AdminOrderDao adminOrderDao = new AdminOrderDaoImpl();
	
	public Map getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public boolean deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}
	
	public boolean deleteUsers(int[] ids) {
		return userDao.deleteUsers(ids);
	}
	
	public UserPager getUserPager(int index, int pageSize) {
		return userDao.getUserPager(index, pageSize);
	}
	
	public List getSubTypeBySuperTypeId(int superTypeId) {
		return subTypeDao.getSubTypeBySuperTypeId(superTypeId);
	}
	
	public boolean addSubType(SubType type) {
		return subTypeDao.addSubType(type);
	}
	public boolean checkSubTypeIsExist(String subTypeName) {
		return subTypeDao.checkSubTypeIsExist(subTypeName);
	}
	
	public List getSuperType() {
		return superTypeDao.getSuperType();
	}
	
	public boolean addSuperType(SuperType type) {
		return superTypeDao.addSuperType(type);
	}
	public boolean checkSuperTypeIsExist(String superTypeName) {
		return superTypeDao.checkSuperTypeIsExist(superTypeName);
	}
	
	public List getAllBooks() {
		return bookDao.getAllBooks();
	}
	
	public boolean addBook(Book book) {
		return bookDao.addBook(book);
	}
	
	public boolean checkBookNameIsExist(String bookName) {
		return bookDao.checkBookNameIsExist(bookName);
	}

	public boolean checkISBNIsExist(String ISBN) {
		return bookDao.checkISBNIsExist(ISBN);
	}
	
	public BookPager searchBook(String bookName) {
		return bookDao.searchBook(bookName);
	}

	public List getAllBookName() {
		return bookDao.getAllBookName();
	}
	public BookPager getBookPager(int index,int pageSize) {
		return bookDao.getBookPager(index, pageSize);
	}
	public boolean deleteBook(int[] bookIds) {
		return bookDao.deleteBook(bookIds);
	}
	
	public List getAllNotes() {
		return noteDao.getAllNotes();
	}
	public boolean deleteNote(int[] ids) {
		return noteDao.deleteNote(ids);
	}
	public NotePager getNotePager(int index, int pageSize) {
		return noteDao.getNotePager(index, pageSize);
	}
	
	public boolean login(Admin admin) {
		return adminLoginDao.login(admin);
	}
	public boolean updatePassword(Admin admin) {
		return adminLoginDao.updatePassword(admin);
	}
	
	public boolean addInform(Inform inform) {
		return adminInformDao.addInform(inform);
	}
	
	public List<Inform> getAllInform() {
		return adminInformDao.getAllInform();
	}
	
	public boolean deleteInform(int[] ids) {
		return adminInformDao.deleteInform(ids);
	}
	
	public Inform getOneInform(int id) {
		return adminInformDao.getOneInform(id);
	}
	public InformPager getInformPager(int index, int pageSize) {
		return adminInformDao.getInformPager(index, pageSize);
	}
	
	public List getAllOrder() {
		return adminOrderDao.getAllOrder();
	}
	public Order getOneOrder(int id) {
		return adminOrderDao.getOneOrder(id);
	}
	
	public List getNotSendOrder(int flag) {
		return adminOrderDao.getNotSendOrder(flag);
	}

	public List getSendOrder(int flag) {
		return adminOrderDao.getSendOrder(flag);
	}

	public boolean SendOrder(int[] orderids) {
		return adminOrderDao.SendOrder(orderids);
	}
	public OrderPager getOrderPager(int index, int pageSize) {
		return adminOrderDao.getOrderPager(index, pageSize);
	}
	public OrderSendPager getOrderSendPager(int index, int pageSize) {
		return adminOrderDao.getOrderSendPager(index, pageSize);
	}
	public boolean deleteOrder(int[] ids) {
		return adminOrderDao.deleteOrder(ids);
	}
	public OrderNotSendPager getOrderNotSendPager(int index, int pageSize) 

	{
		return adminOrderDao.getOrderNotSendPager(index, pageSize);
	}
	public OrderFreezePager getOrderFreezePager(int index,int pageSize) {
		return adminOrderDao.getOrderFreezePager(index, pageSize);
	}
	public boolean freezeOrder(int[] orderids) {
		return adminOrderDao.freezeOrder(orderids);
	}
	
	//根据当前用户的用户名查订单
	public List<Order> selectOrder(String name){
		return od.selectOrder(name);
	}
	//根据订单号查订单项
	public List<OrderItem> selectOrderItem(int id ){
		return od.selectOrderItem(id);
	}
	/* 用户旧密码 */
	public Boolean loggin(String name, String password){
		return ud.loggin(name, password);
	}
	/* 用于查询会员的个人信息资料 */
	public User SelectOneUser(String name){
		return ud.SelectOneUser(name);
	}
	 /* 用于修改用户的个人密码 */
	public Boolean updatePassword(String name, String password){
		return ud.updatePassword(name, password);
	}

	/* 用于完善会员的 其它资料 */
	public Boolean updateUser(User user) {
		return ud.updateUser(user);
	}
}
