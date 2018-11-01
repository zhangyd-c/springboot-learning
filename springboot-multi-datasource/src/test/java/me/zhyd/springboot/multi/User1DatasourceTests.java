package me.zhyd.springboot.multi;

import com.github.pagehelper.PageHelper;
import me.zhyd.springboot.multi.entity.Users;
import me.zhyd.springboot.multi.mapper.primary.User1Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User1DatasourceTests {

	@Autowired
	private User1Mapper user1Mapper;

	@Test
	public void listByMapperXmlTest() {
		List<Users> testList = user1Mapper.selectAllByXml();
		System.out.println(testList.size() + "============================");
	}

	@Test
	public void listTest() {
		List<Users> testList = user1Mapper.selectAll();
		System.out.println(testList.size());
	}

	@Test
	public void pageHelperTest() {
		PageHelper.startPage(0, 1);
		List<Users> testList = user1Mapper.selectAll();
		System.out.println(testList.size());
	}

	@Test
	@Transactional("primaryTestTransactionManager")
	public void insertTest() {
		int i = user1Mapper.insert(getUser(2));
		int ii = 1/0;
		Assert.assertEquals(i,1);
	}

	@Test
	public void insertListTest() {
		List<Users> testList = new ArrayList<>();
		for(int i = 0; i < 10 ; i ++){
			testList.add(getUser(2));
		}
		user1Mapper.insertList(testList);
	}

	@Test
	public void removeByPrimaryKeyTest(){
		int i = user1Mapper.deleteByPrimaryKey(Integer.valueOf(117));
		Assert.assertEquals(i,1);
	}

	@Test
	public void removeByEntityTest(){
		Users user = new Users();
		user.setId(116);
		int i = user1Mapper.delete(user);
		Assert.assertEquals(i,1);
	}

	@Test
	public void updateTest(){
		Users user = new Users();
		user.setId(117);
		user.setNickName("aaaaaaaaaaaaa");
		user1Mapper.updateByPrimaryKey(user);
	}

	@Test
	public void updateSelectiveTest(){
		Users test = new Users("username", "password", "男人");
		user1Mapper.updateByPrimaryKeySelective(test);
	}

	@Test
	public void getByPrimaryKeyTest(){
		Users user = user1Mapper.selectByPrimaryKey(121);
		Assert.assertNotEquals(user, null);
	}

	@Test
	public void listByEntityTest(){
		Users test = new Users("username", "password", "男人");
		user1Mapper.select(test);
	}

	public static Users getUser(int max) {
		String username = "username";
		int len = new Random().nextInt(max);
		for(int i = 0 ; i < len; i ++){
			username += username;
		}
		return new Users(username, "password", "男人");
	}

}
