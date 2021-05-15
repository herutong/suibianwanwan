package com.lottery.dao;

import com.lottery.entity.Member;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml"})
public class MemberDaoTest  {

    @Autowired
    private MemberDao memberDao;
    @Test
    public void testFindMemberByAccount() throws Exception {
        Member june = memberDao.findMemberByAccount("June");
        System.out.println(june);

    }
}