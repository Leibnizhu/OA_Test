package leibniz.hu.oatest.test;

import leibniz.hu.oatest.domain.Menu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MenuTest {
	@Test
	public void addMenu(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
/***********************************************************************************/
		/*
		 * 个人办公
		 */
		Menu Menu1 = new Menu();
		Menu1.setMid(1L);
		Menu1.setIcon("css/images/MenuIcon/FUNC20082.gif");
		Menu1.setMname("办公自动化");
		Menu1.setPid(0L);
		//Menu1.setChecked(false);
		Menu1.setIsParent(true);
		
		Menu Menu2 = new Menu();
		Menu2.setMid(2L);
		Menu2.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Menu2.setMname("个人办公");
		//Menu2.setChecked(false);
		Menu2.setPid(1L);
		Menu2.setIsParent(true);
		
		Menu Menu21 = new Menu();
		Menu21.setMid(21L);
		Menu21.setIcon("css/images/MenuIcon/FUNC20054.gif");
		Menu21.setMname("个人考勤");
		//Menu21.setChecked(false);
		Menu21.setPid(2L);
		Menu21.setIsParent(false);
		
		
		Menu Menu22 = new Menu();
		Menu22.setMid(22L);
		Menu22.setIcon("css/images/MenuIcon/FUNC23700.gif");
		Menu22.setMname("日程安排");
		//Menu22.setChecked(false);
		Menu22.setPid(2L);
		Menu22.setIsParent(false);
		
		Menu Menu23 = new Menu();
		Menu23.setMid(23L);
		Menu23.setIcon("css/images/MenuIcon/FUNC20069.gif");
		Menu23.setMname("工作计划");
		//Menu23.setChecked(false);
		Menu23.setPid(2L);
		Menu23.setIsParent(false);
		
		Menu Menu24 = new Menu();
		Menu24.setMid(24L);
		Menu24.setIcon("css/images/MenuIcon/FUNC20056.gif");
		Menu24.setMname("工作日记");
		//Menu24.setChecked(false);
		Menu24.setPid(2L);
		Menu24.setIsParent(false);
		
		Menu Menu25 = new Menu();
		Menu25.setMid(25L);
		Menu25.setIcon("css/images/MenuIcon/time_date.gif");
		Menu25.setMname("通讯录");
		//Menu25.setChecked(false);
		Menu25.setPid(2L);
		Menu25.setIsParent(false);
/*********************************************************************************/	
		/*
		 * 审批流转
		 */
		Menu Menu3 = new Menu();
		Menu3.setMid(3L);
		///Menu3.setChecked(false);
		Menu3.setIsParent(true);
		Menu3.setPid(1L);
		Menu3.setMname("审批流转");
		Menu3.setIcon("css/images/MenuIcon/FUNC20057.gif");
		
		Menu Menu31 = new Menu();
		Menu31.setMid(31L);
		//Menu31.setChecked(false);
		Menu31.setIsParent(false);
		Menu31.setPid(3L);
		Menu31.setMname("审批流程管理");
		Menu31.setIcon("css/images/MenuIcon/manager.gif");
		
		Menu Menu32 = new Menu();
		Menu32.setMid(32L);
		//Menu32.setChecked(false);
		Menu32.setIsParent(false);
		Menu32.setPid(3L);
		Menu32.setMname("表单模板管理");
		Menu32.setIcon("css/images/MenuIcon/formmodel.gif");
		
		Menu Menu33 = new Menu();
		Menu33.setMid(33L);
		Menu33.setIsParent(false);
		//Menu33.setChecked(false);
		Menu33.setPid(3L);
		Menu33.setMname("发起申请");
		Menu33.setIcon("css/images/MenuIcon/FUNC241000.gif");
		
		Menu Menu34 = new Menu();
		Menu34.setMid(34L);
		Menu34.setIsParent(false);
		//Menu34.setChecked(false);
		Menu34.setPid(3L);
		Menu34.setMname("审批申请");
		Menu34.setIcon("css/images/MenuIcon/FUNC20029.gif");
		
		Menu Menu35 = new Menu();
		Menu35.setMid(35L);
		Menu35.setIsParent(false);
		//Menu35.setChecked(false);
		Menu35.setPid(3L);
		Menu35.setMname("状态查询");
		Menu35.setIcon("css/images/MenuIcon/FUNC20029.gif");
/************************************************************************************/
		/*
		 * 知识管理
		 */
		Menu Menu4 = new Menu();
		Menu4.setMid(4L);
		Menu4.setIsParent(false);
		//Menu4.setChecked(false);
		Menu4.setPid(1L);
		Menu4.setMname("知识管理");
		Menu4.setIcon("css/images/MenuIcon/FUNC20056.gif");
/*******************************************************************************/
		/*
		 * 综合行政
		 */
		Menu Menu5 = new Menu();
		Menu5.setMid(5L);
		Menu5.setIsParent(true);
		//Menu5.setChecked(false);
		Menu5.setPid(1L);
		Menu5.setMname("管理行政");
		Menu5.setIcon("css/images/MenuIcon/manager.gif");
		
		Menu Menu51 = new Menu();
		Menu51.setMid(51L);
		Menu51.setIsParent(false);
		//Menu51.setChecked(false);
		Menu51.setPid(5L);
		Menu51.setMname("考勤管理");
		Menu51.setIcon("css/images/MenuIcon/FUNC20070.gif");
		
		Menu Menu52 = new Menu();
		Menu52.setMid(52L);
		Menu52.setIsParent(false);
		//Menu52.setChecked(false);
		Menu52.setPid(5L);
		Menu52.setMname("会议管理");
		Menu52.setIcon("css/images/MenuIcon/FUNC20064.gif");
		
		Menu Menu53 = new Menu();
		Menu53.setMid(53L);
		Menu53.setIsParent(false);
		//Menu53.setChecked(false);
		Menu53.setPid(5L);
		Menu53.setMname("车辆管理");
		Menu53.setIcon("css/images/MenuIcon/radio_blue.gif");
/**************************************************************************************/
		/*
		 * 人力资源管理
		 * 	档案管理
		 * 	培训记录
		 * 	奖金记录
		 * 	职位变更
		 * 	人事合同
		 * 	薪酬制度
		 */
		Menu Menu6 = new Menu();
		Menu6.setMid(6L);
		Menu6.setIsParent(true);
		//Menu6.setChecked(false);
		Menu6.setPid(1L);
		Menu6.setMname("人力资源");
		Menu6.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		Menu Menu61 = new Menu();
		Menu61.setMid(61L);
		Menu61.setIsParent(false);
		//Menu61.setChecked(false);
		Menu61.setPid(6L);
		Menu61.setMname("档案管理");
		Menu61.setIcon("css/images/MenuIcon/FUNC20076.gif");
		
		Menu Menu62 = new Menu();
		Menu62.setMid(62L);
		Menu62.setIsParent(false);
		//Menu62.setChecked(false);
		Menu62.setPid(6L);
		Menu62.setMname("培训记录");
		Menu62.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Menu Menu63 = new Menu();
		Menu63.setMid(63L);
		Menu63.setIsParent(false);
		//Menu63.setChecked(false);
		Menu63.setPid(6L);
		Menu63.setMname("奖赏记录");
		Menu63.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Menu Menu64 = new Menu();
		Menu64.setMid(64L);
		Menu64.setIsParent(false);
		//Menu64.setChecked(false);
		Menu64.setPid(6L);
		Menu64.setMname("职位变更");
		Menu64.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Menu Menu65 = new Menu();
		Menu65.setMid(65L);
		Menu65.setIsParent(false);
		//Menu65.setChecked(false);
		Menu65.setPid(6L);
		Menu65.setMname("人事合同");
		Menu65.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Menu Menu66 = new Menu();
		Menu66.setMid(66L);
		Menu66.setIsParent(false);
		//Menu66.setChecked(false);
		Menu66.setPid(6L);
		Menu66.setMname("薪酬制度");
		Menu66.setIcon("css/images/MenuIcon/FUNC20001.gif");
/*****************************************************************************************/
		/*
		 * 电子邮件
		 */
		Menu Menu7 = new Menu();
		Menu7.setMid(7L);
		Menu7.setIsParent(false);
		//Menu7.setChecked(false);
		Menu7.setPid(1L);
		Menu7.setMname("电子邮件");
		Menu7.setIcon("css/images/MenuIcon/eml.gif");

/*******************************************************************/
		/*
		 * 实用工具
		 * 	车票预定
		 * 	GIS查询
		 * 	邮政编码
		 */
		Menu Menu8 = new Menu();
		Menu8.setMid(8L);
		Menu8.setIsParent(true);
		//Menu8.setChecked(false);
		Menu8.setPid(1L);
		Menu8.setMname("实用工具");
		Menu8.setIcon("css/images/MenuIcon/FUNC20076.gif");
		Menu Menu81 = new Menu();
		Menu81.setMid(81L);
		Menu81.setIsParent(false);
		//Menu81.setChecked(false);
		Menu81.setPid(8L);
		Menu81.setMname("车票预定");
		Menu81.setIcon("css/images/MenuIcon/FUNC220000.gif");
		Menu Menu82 = new Menu();
		Menu82.setMid(82L);
		Menu82.setIsParent(false);
		//Menu82.setChecked(false);
		Menu82.setPid(8L);
		Menu82.setMname("GIS查询");
		Menu82.setIcon("css/images/MenuIcon/search.gif");
		Menu Menu83 = new Menu();
		Menu83.setMid(83L);
		Menu83.setIsParent(false);
		//Menu83.setChecked(false);
		Menu83.setPid(8L);
		Menu83.setMname("邮政编码");
		Menu83.setIcon("css/images/MenuIcon/FUNC249000.gif");
/**************************************************************************/
		/*
		 * 个人设置
		 * 		个人信息
		 * 		密码修改
		 */
		Menu Menu9 = new Menu();
		Menu9.setMid(9L);
		Menu9.setIsParent(true);
		//Menu9.setChecked(false);
		Menu9.setPid(1L);
		Menu9.setMname("个人设置");
		Menu9.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Menu Menu91 = new Menu();
		Menu91.setMid(91L);
		Menu91.setIsParent(false);
		//Menu91.setChecked(false);
		Menu91.setPid(9L);
		Menu91.setMname("个人信息");
		Menu91.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Menu Menu92 = new Menu();
		Menu92.setMid(92L);
		Menu92.setIsParent(false);
		//Menu92.setChecked(false);
		Menu92.setPid(9L);
		Menu92.setMname("密码修改");
		Menu92.setIcon("css/images/MenuIcon/FUNC241000.gif");
/***********************************************************************************/
		/*
		 * 系统管理
		 * 	岗位管理
		 * 	部门管理
		 * 	用户管理
		 */
		Menu Menu10 = new Menu();
		Menu10.setMid(10L);
		Menu10.setIsParent(true);
		//Menu10.setChecked(false);
		Menu10.setPid(1L);
		Menu10.setMname("系统管理");
		Menu10.setIcon("css/images/MenuIcon/system.gif");
		Menu Menu101 = new Menu();
		Menu101.setMid(101L);
		Menu101.setIsParent(false);
		//Menu101.setChecked(false);
		Menu101.setPid(10L);
		Menu101.setMname("岗位管理");
		Menu101.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Menu Menu102 = new Menu();
		Menu102.setMid(102L);
		Menu102.setIsParent(false);
		//Menu102.setChecked(false);
		Menu102.setPid(10L);
		Menu102.setMname("部门管理");
		Menu102.setIcon("css/images/MenuIcon/department.gif");
		Menu Menu103 = new Menu();
		Menu103.setMid(103L);
		Menu103.setIsParent(false);
		//Menu103.setChecked(false);
		Menu103.setPid(10L);
		Menu103.setMname("用户管理");
		Menu103.setIcon("css/images/MenuIcon/FUNC20001.gif");
/**********************************************************************/
		/*
		 * {
		 * 	1,1
		 * 	2,5
		 * 	3,5
		 * 	4,1
		 * 	5,3
		 * 	6,6
		 * 	7,1
		 * 	8,3
		 * 	9,2
		 * 	10,3
		 * }
		 */
		
		session.save(Menu1);
		
		session.save(Menu2);
		session.save(Menu21);
		session.save(Menu22);
		session.save(Menu23);
		session.save(Menu24);
		session.save(Menu25);
		
		
		session.save(Menu3);
		session.save(Menu31);
		session.save(Menu32);
		session.save(Menu33);
		session.save(Menu34);
		session.save(Menu35);
		
		session.save(Menu4);
		
		session.save(Menu5);
		session.save(Menu51);
		session.save(Menu52);
		session.save(Menu53);
		
		session.save(Menu6);
		
		session.save(Menu61);
		session.save(Menu62);
		session.save(Menu63);
		session.save(Menu64);
		session.save(Menu65);
		session.save(Menu66);
		
		session.save(Menu7);
		
		session.save(Menu8);
		session.save(Menu81);
		session.save(Menu82);
		session.save(Menu83);
		
		session.save(Menu9);
		session.save(Menu91);
		session.save(Menu92);
		
		session.save(Menu10);
		session.save(Menu101);
		session.save(Menu102);
		session.save(Menu103);
		transaction.commit();
		session.close();
	}
}
