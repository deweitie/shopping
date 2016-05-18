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
	//�û�ע��
	public boolean addUser(User user) {
		return ud.addUser(user);
	}
	//�û���¼
	public User userLogin(String name,String password) {
		return ud.userLogin(name,password);
	}
	//����û����Ƿ����
	public boolean checkNameExist(String name){
		return ud.checkNameExist(name);
	}
	//�û�����ҳ��
	public List listUser() {
		return ud.listUser();
	}
	//��ҳ��ʾ�û�
//	public Page doPage(int currentPage,int pageSize){
//		return ud.doPage(currentPage, pageSize);
//	}
	//����IDɾ���û�
	public boolean delete(int id,String powerType){
		return ud.delete(id,powerType);
	}
	//����ID�����û�Ȩ��
	public boolean changePower(int id,String powerType){
		return ud.changePower(id,powerType);
	}
	//	 �����û�������ȡ��Ȩ��
	public String getPower(String name){
		return ud.getPower(name);
	}
	//�����û������ҵ����û�
	public User getUser(String name){
		return ud.getUser(name);
	}
	//��ʾ�鼮
	public List<Book> showBooks(int type,int flag) {
		return bd.showBooks(type, flag);
	}
	//�����鼮��bookId����ʾ�鼮����ϸ��Ϣ
	public Book showBookById(int bookId){
		return bd.showBookById(bookId);
	}
	//��Ӷ����������ض�һ������
	public int addOrder(Order order){
		return od.addOrder(order);
	}
	//��ҳ��ʾ�鼮
	public Page doPage(int type,int currentPage,int pageSize){
		return bd.doPage(type,currentPage, pageSize);
	}
	//����������Ĺؼ�����������鼮
	public List<Book> searchBooks(String keywords){
		return bd.searchBooks(keywords);
	}
	/**
	 * ��ҳ��ʾ�鼮
	 * @param currentPage ��ʾ�����ĵ�ǰҳ��
	 * @param pageSize ÿҳ��ʾ��Ŀ
	 * @return Page
	 */
	public Page doPage(String keywords,int currentPage,int pageSize){
		return bd.doPage(keywords, currentPage, pageSize);
	}
	//��ʾ�����û�����
	public List<Note> showNote(){
		return ud.showNote();
	}
	/**
	 * ��ҳ��ʾ�����û�����
	 * @param currentPage ��ʾ�����ĵ�ǰҳ��
	 * @param pageSize ÿҳ��ʾ��Ŀ
	 * @return Page
	 */
	public Page doNotePage(int currentPage,int pageSize){
		return ud.doNotePage(currentPage, pageSize);
	}
	//�û��������
	public boolean addNote(Note note){
		return ud.addNote(note);
	}
	/**
	 * �����û�ѡ�������������������鼮
	 * @param superTypeId ���������ID
	 * @param subTypeId ����С���ID
	 * @param searchMethod �������ǰ����ߡ������������硢ISBN���۸��е�һ����
	 * @param upLoadTime �鼮�ϼ�ʱ��
	 * @return List
	 */
	public List<?> searchBooksByConditions(int superTypeId,int subTypeId,String searchMethod,String upLoadTime){
		return bd.searchBooksByConditions(superTypeId, subTypeId, searchMethod, upLoadTime);
	}
	/**
	 * �����û�ѡ�������������������鼮
	 * @param superTypeId ���������ID
	 * @param subTypeId ����С���ID
	 * @param searchMethod �������ǰ����ߡ������������硢ISBN���۸��е�һ����
	 * @param upLoadTime �鼮�ϼ�ʱ��
	 */
	public Page doPageByConditons(int superTypeId,int subTypeId,String searchMethod,String upLoadTime,int currentPage,int pageSize){
		return bd.doPageByConditons(superTypeId, subTypeId, searchMethod, upLoadTime, currentPage, pageSize);
	}
	
	
	
	/**
	 * 
	 * ��̨����
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
	
	//���ݵ�ǰ�û����û����鶩��
	public List<Order> selectOrder(String name){
		return od.selectOrder(name);
	}
	//���ݶ����Ų鶩����
	public List<OrderItem> selectOrderItem(int id ){
		return od.selectOrderItem(id);
	}
	/* �û������� */
	public Boolean loggin(String name, String password){
		return ud.loggin(name, password);
	}
	/* ���ڲ�ѯ��Ա�ĸ�����Ϣ���� */
	public User SelectOneUser(String name){
		return ud.SelectOneUser(name);
	}
	 /* �����޸��û��ĸ������� */
	public Boolean updatePassword(String name, String password){
		return ud.updatePassword(name, password);
	}

	/* �������ƻ�Ա�� �������� */
	public Boolean updateUser(User user) {
		return ud.updateUser(user);
	}
}
