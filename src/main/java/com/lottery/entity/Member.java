package com.lottery.entity;


public class Member {
    private String memberAccount;
    private String memberPassword;
    private String memberEmail;
    private String memberName;
    private String memberPhone;
    private String memberLeader;
    private String memberGroup;
    private String memberNumStatus;
    private String memberSee;

    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberLeader() {
        return memberLeader;
    }

    public void setMemberLeader(String memberLeader) {
        this.memberLeader = memberLeader;
    }

    public String getMemberGroup() {
        return memberGroup;
    }

    public void setMemberGroup(String memberGroup) {
        this.memberGroup = memberGroup;
    }

    public String getMemberNumStatus() {
        return memberNumStatus;
    }

    public void setMemberNumStatus(String memberNumStatus) {
        this.memberNumStatus = memberNumStatus;
    }

    public String getMemberSee() {
        return memberSee;
    }

    public void setMemberSee(String memberSee) {
        this.memberSee = memberSee;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Member{");
        sb.append("memberAccount='").append(memberAccount).append('\'');
        sb.append(", memberPassword='").append(memberPassword).append('\'');
        sb.append(", memberEmail='").append(memberEmail).append('\'');
        sb.append(", memberName='").append(memberName).append('\'');
        sb.append(", memberPhone='").append(memberPhone).append('\'');
        sb.append(", memberLeader='").append(memberLeader).append('\'');
        sb.append(", memberGroup='").append(memberGroup).append('\'');
        sb.append(", memberNumStatus='").append(memberNumStatus).append('\'');
        sb.append(", memberSee='").append(memberSee).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
