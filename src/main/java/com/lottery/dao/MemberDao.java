package com.lottery.dao;

import com.lottery.entity.Member;
import org.apache.ibatis.annotations.Param;

/**
 * 描述
 * User: shuai
 * Date: 2017/3/2  Time: 13:32
 */
public interface MemberDao {
    public Member findMemberByAccount(@Param("memberAccount") String memberAccount);
}
