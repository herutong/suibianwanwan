package com.lottery.shiro;


import com.lottery.dao.MemberDao;
import com.lottery.dao.RoleDao;
import com.lottery.entity.Member;
import com.lottery.entity.Role;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        Member member =memberDao.findMemberByAccount(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(findRoles(member.getRoleId()));
        return authorizationInfo;
    }
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for (Long roleId : roleIds) {
            Role role =roleDao.findOne(roleId);
            if (role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();
        Member member= null;
        try{
             member = memberDao.findMemberByAccount(username);
            logger.info(member.toString());
        }catch (Exception e){
            logger.error(e.getMessage());
        }


        if(member == null) {
            throw new UnknownAccountException();//???????????????
        }

        if(Boolean.TRUE.equals(member.getLock())) {
            throw new LockedAccountException(); //????????????
        }

        //??????AuthenticatingRealm??????CredentialsMatcher?????????????????????????????????????????????????????????????????????
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                member.getMemberAccount(), //?????????
                member.getMemberPassword(), //??????
                ByteSource.Util.bytes(member.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }


}
