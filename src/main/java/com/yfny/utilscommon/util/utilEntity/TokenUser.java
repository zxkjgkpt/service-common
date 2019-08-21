package com.yfny.utilscommon.util.utilEntity;

/**
 * class name
 * <p>
 * Created  by  renxingWei  on  2019/5/23
 **/
public class TokenUser {
    private String NXsessionId;
    private String userId;
    private String userAccount;
    private String currentRoleId;
    private String currentRoleName;
    private String currentCorpId;
    private String currentCorpName;
    private String currentDeptId;
    private String currentDeptName;
    private String defaultRoleId;
    private String description;

    public TokenUser() {
    }

    public TokenUser(String userId, String userAccount) {
        this.userId = userId;
        this.userAccount = userAccount;
    }

    public String getNXsessionId() {
        return NXsessionId;
    }

    public void setNXsessionId(String NXsessionId) {
        this.NXsessionId = NXsessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getCurrentRoleId() {
        return currentRoleId;
    }

    public void setCurrentRoleId(String currentRoleId) {
        this.currentRoleId = currentRoleId;
    }

    public String getCurrentRoleName() {
        return currentRoleName;
    }

    public void setCurrentRoleName(String currentRoleName) {
        this.currentRoleName = currentRoleName;
    }

    public String getCurrentCorpId() {
        return currentCorpId;
    }

    public void setCurrentCorpId(String currentCorpId) {
        this.currentCorpId = currentCorpId;
    }

    public String getCurrentCorpName() {
        return currentCorpName;
    }

    public void setCurrentCorpName(String currentCorpName) {
        this.currentCorpName = currentCorpName;
    }

    public String getCurrentDeptId() {
        return currentDeptId;
    }

    public void setCurrentDeptId(String currentDeptId) {
        this.currentDeptId = currentDeptId;
    }

    public String getCurrentDeptName() {
        return currentDeptName;
    }

    public void setCurrentDeptName(String currentDeptName) {
        this.currentDeptName = currentDeptName;
    }

    public String getDefaultRoleId() {
        return defaultRoleId;
    }

    public void setDefaultRoleId(String defaultRoleId) {
        this.defaultRoleId = defaultRoleId;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TokenUser{" +
                "NXsessionId='" + NXsessionId + '\'' +
                ", userId='" + userId + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", currentRoleId='" + currentRoleId + '\'' +
                ", currentRoleName='" + currentRoleName + '\'' +
                ", currentCorpId='" + currentCorpId + '\'' +
                ", currentCorpName='" + currentCorpName + '\'' +
                ", currentDeptId='" + currentDeptId + '\'' +
                ", currentDeptName='" + currentDeptName + '\'' +
                ", defaultRoleId='" + defaultRoleId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
